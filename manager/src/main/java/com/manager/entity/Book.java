package com.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guiyi
 * @Date 2023/12/18 12:55:03
 * @ClassName com.manager.entity.Book
 * @function -->
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String bookTime;
    private String stuId;
    private Integer bookSeatId;
    private Integer bookArrive;
}
