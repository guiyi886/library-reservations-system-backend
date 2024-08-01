package com.student.pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInfoVO {
    public String bookTime;
    public String roomName;
    public Integer seatRowId;
    public Integer seatColumnId;
    public boolean bookArrive;
}
