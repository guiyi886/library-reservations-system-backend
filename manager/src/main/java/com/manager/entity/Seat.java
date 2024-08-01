package com.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guiyi
 * @Date 2023/12/19 16:36:18
 * @ClassName com.manager.entity.Seat
 * @function -->
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
    private Long id;
    private Boolean seatState;
    private Long seatPositionId;
    private Integer seatRowId;
    private Integer seatColumnId;
}
