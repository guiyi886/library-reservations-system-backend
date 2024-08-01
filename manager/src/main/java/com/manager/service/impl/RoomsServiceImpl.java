package com.manager.service.impl;

import com.manager.entity.Room;
import com.manager.exctptions.RoomException;
import com.manager.mapper.RoomMapper;
import com.manager.service.RoomsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/19 15:50:16
 * @ClassName com.manager.service.impl.RoomsServiceImpl
 * @function -->
 */
@Service
@Slf4j
public class RoomsServiceImpl implements RoomsService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public Room getRoom(Integer roomId) {
        Room room = roomMapper.getRoom(roomId);
        if (room == null) {
            throw new RoomException("该阅览室不存在！");
        }
        return room;

    }

    @Override
    public void deleteRoom(Integer roomId) {
        Integer flag = roomMapper.deleteRoom(roomId);
        if (flag == 0) {
            throw new RoomException("该阅览室不存在！");
        }
    }

    @Override
    public List<Room> getRoomAll() {
        return roomMapper.getRoomAll();
    }

    @Override
    public void createRoom(Room room) {
        roomMapper.createRoom(room);
        ;
    }

    @Override
    public void changeRoomState(Integer roomId) {
        roomMapper.changeRoomState(roomId);
    }
}
