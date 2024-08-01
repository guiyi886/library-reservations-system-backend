package com.student.pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReadingRoomSearchVO {
    public String name;
    public Integer seatNum;
    public Integer bookedSeat;
}
