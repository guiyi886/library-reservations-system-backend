package com.manager.service;

import com.manager.entity.Room;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/19 15:50:04
 * @ClassName com.manager.service.RoomsService
 * @function -->
 */
public interface RoomsService {

    Room getRoom(Integer roomId);

    void deleteRoom(Integer roomId);

    List<Room> getRoomAll();

    void createRoom(Room room);

    void changeRoomState(Integer roomId);
}
