package com.manager.service.impl;

import com.manager.entity.Seat;
import com.manager.exctptions.SeatException;
import com.manager.mapper.SeatMapper;
import com.manager.service.SeatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/19 16:33:12
 * @ClassName com.manager.service.impl.SeatServiceImpl
 * @function -->
 */
@Service
@Slf4j
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;

    /**
     * @date 2023/12/19 05:04:08
     * @function -->获取座位状态
     */
    @Override
    public Integer getState(Integer seatId) {
        Integer state = seatMapper.getState(seatId);
//        log.info("state:{}", state);
        if (state == null) {
            throw new SeatException("该座位不存在!");
        }
        return state;
    }

    /**
     * @date 2023/12/19 05:04:14
     * @function --> 取反座位状态
     */
    @Override
    public Integer reState(Integer seatId) {
        Integer flag = seatMapper.reState(seatId);
//        log.info("flag:{}", flag);
        if (flag == 0) {    //update语句只会返回0和1代表失败和成功，不是null
            throw new SeatException("该座位不存在!");
        }
        return seatMapper.getState(seatId);
    }

    @Override
    public List<Seat> getSeatAll(Integer seatPositionId) {

        return seatMapper.getSeatAll(seatPositionId);
    }
}
