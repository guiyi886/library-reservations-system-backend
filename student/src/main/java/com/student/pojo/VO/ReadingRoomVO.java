package com.student.pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingRoomVO {
    public Integer id;
    public String roomName;
    public boolean roomState;
    public String roomType;
    public String roomCreateTime;
    public Integer roomSeatNum;
    public Integer availableNumber;
    public Integer roomSeatRowNum;
    public Integer roomSeatColumnNum;
    public Integer[][] seatArray;
}
