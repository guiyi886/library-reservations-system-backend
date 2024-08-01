package com.student.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.student.mapper.ReadingRoomMapper;
import com.student.pojo.DTO.RoomPageDTO;
import com.student.pojo.ReadingRoomPage;
import com.student.pojo.ReadingRoomSimple;
import com.student.pojo.VO.ReadingRoomSearchVO;
import com.student.pojo.VO.ReadingRoomVO;
import com.student.pojo.VO.SeatVO;
import com.student.service.RoomPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoomPageServiceImpl implements RoomPageService {
    @Autowired
    ReadingRoomMapper readingRoomMapper;

    @Override
    public ReadingRoomPage getRoomPage(RoomPageDTO roomPageDTO) {
        PageHelper.startPage(roomPageDTO.getPage_num(),roomPageDTO.getPage_size());

        Page<ReadingRoomSimple> page =  readingRoomMapper.getRoomPage(roomPageDTO);

        log.info("ans:{}", page);
        int total = (int)page.getTotal();
        List<ReadingRoomSimple> records = page.getResult();
        return new ReadingRoomPage(total, records);
    }

    @Override
    public ReadingRoomVO getRoomDetail(Integer id) {
        ReadingRoomVO readingRoomVO = readingRoomMapper.getRoomDetail(id);
        log.info("获取阅览室详细信息：{}", readingRoomVO);
        int row  = readingRoomVO.getRoomSeatRowNum();
        int list = readingRoomVO.getRoomSeatColumnNum();

        //获取座位列表
        List<SeatVO> seatList = readingRoomMapper.getSeat(id);
        log.info("获取座位信息：{}", seatList);

        //将座位列表放进数组
        Integer[][] seatArray = new Integer[row][list];
        for(SeatVO element : seatList){
            seatArray[element.seatRowId-1][element.seatColumnId-1] = element.seatState;
        }
        readingRoomVO.seatArray = seatArray;
        return readingRoomVO;
    }

    public ReadingRoomSearchVO searchRoom(String name){
        ReadingRoomSearchVO readingRoomSearchVO = readingRoomMapper.search(name);
        return readingRoomSearchVO;
    }

    @Override
    public Integer getReadingRoomNum() {
        return readingRoomMapper.getReadingRoomNumber();
    }
}
