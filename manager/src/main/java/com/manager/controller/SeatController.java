package com.manager.controller;

import com.manager.result.Result;
import com.manager.service.impl.SeatServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guiyi
 * @Date 2023/12/19 16:36:47
 * @ClassName com.manager.controller.SeatController
 * @function -->
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/managers/seats")
public class SeatController {
    @Autowired
    private SeatServiceImpl seatServiceImpl;

    @RequestMapping("/state")
    public Result getState(@RequestParam Integer seatId) {
        log.info("座位号：{}-->获取座位状态", seatId);
        return Result.success(seatServiceImpl.getState(seatId), "获取座位状态成功");
    }

    @PutMapping("/reState")
    public Result reState(@RequestParam Integer seatId) {
        log.info("座位号：{}-->更改座位状态", seatId);
        return Result.success(seatServiceImpl.reState(seatId), "更改座位状态成功");
    }

    @GetMapping("/all")
    public Result getSeatAll(@RequestParam Integer seatPositionId) {
        log.info("返回阅览室id-->{}的全部座位", seatPositionId);
        return Result.success(seatServiceImpl.getSeatAll(seatPositionId), "返回特定阅览室的全部座位");
    }
}
