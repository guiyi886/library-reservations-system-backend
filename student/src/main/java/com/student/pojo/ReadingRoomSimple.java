package com.student.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadingRoomSimple {
    public Integer id;
    public String roomName;
    public Integer roomSeatNum;
    public Integer roomBookedSeatNum;
}
