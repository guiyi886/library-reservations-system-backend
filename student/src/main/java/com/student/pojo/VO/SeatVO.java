package com.student.pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatVO {
    public Integer seatRowId;
    public Integer seatColumnId;
    public Integer seatState;
}
