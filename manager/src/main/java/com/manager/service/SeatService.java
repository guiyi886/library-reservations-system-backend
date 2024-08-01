package com.manager.service;

import com.manager.entity.Seat;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/19 16:32:52
 * @ClassName com.manager.service.SeatService
 * @function -->
 */
public interface SeatService {

    Integer getState(Integer seatId);

    Integer reState(Integer seatId);

    List<Seat> getSeatAll(Integer seatPositionId);
}
