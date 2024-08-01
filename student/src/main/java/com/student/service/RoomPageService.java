package com.student.service;

import com.student.pojo.DTO.RoomPageDTO;
import com.student.pojo.ReadingRoomPage;
import com.student.pojo.VO.ReadingRoomSearchVO;
import com.student.pojo.VO.ReadingRoomVO;

public interface RoomPageService {
    ReadingRoomPage getRoomPage(RoomPageDTO roomPageDTO);

    ReadingRoomVO getRoomDetail(Integer id);

    ReadingRoomSearchVO searchRoom(String name);

    Integer getReadingRoomNum();
}
