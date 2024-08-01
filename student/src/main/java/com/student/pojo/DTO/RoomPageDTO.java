package com.student.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomPageDTO {
    public Integer page_size;
    public Integer page_num;
    public boolean has_empty;
}
