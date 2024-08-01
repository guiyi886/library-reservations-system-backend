package com.manager.controller;

import com.manager.entity.Room;
import com.manager.result.Result;
import com.manager.service.impl.RoomsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guiyi
 * @Date 2023/12/19 15:44:07
 * @ClassName com.manager.controller.RoomsController
 * @function -->
 */
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/managers/rooms")
public class RoomsController {
    @Autowired
    private RoomsServiceImpl roomsServiceImpl;

    @GetMapping
    public Result getRoom(@RequestParam Integer roomId) {
        log.info("获取阅览室信息-->id-->" + roomId);
        return Result.success(roomsServiceImpl.getRoom(roomId), "获取阅览室信息成功");
    }

    @DeleteMapping
    public Result deleteRoom(@RequestParam Integer roomId) {
        log.info("删除阅览室-->id-->" + roomId);
        roomsServiceImpl.deleteRoom(roomId);
        return Result.success(null, "删除阅览室成功");
    }

    @GetMapping("/all")
    public Result getRoomAll() {
        log.info("获取全部阅览室信息");
        return Result.success(roomsServiceImpl.getRoomAll(), "获取全部阅览室信息");
    }

    @PostMapping("/create")
    public Result createRoom(@RequestBody Room room) {
        log.info("创建阅览室");
        roomsServiceImpl.createRoom(room);
        return Result.success(null, "创建阅览室");
    }

    @PutMapping("/reState")
    public Result changeRoomState(@RequestParam Integer roomId) {
        log.info("更改阅览室状态");
        roomsServiceImpl.changeRoomState(roomId);
        return Result.success(null, "更改阅览室状态");
    }
}
