package com.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guiyi
 * @Date 2023/12/19 15:54:34
 * @ClassName com.manager.entity.Room
 * @function -->
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private Integer id;
    private String roomName;
    private boolean roomState;
    private String roomType;
    private String roomCreateTime;
    private int roomSeatNum;
    private int roomBookedSeatNum;
    private int roomSeatRowNum;
    private int roomSeatColumnNum;
}
