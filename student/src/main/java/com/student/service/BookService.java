package com.student.service;

import com.student.pojo.DTO.BookDTO;
import com.student.pojo.VO.BookInfoVO;

public interface BookService {
    void bookSeat(BookDTO bookDTO);

    BookInfoVO getBookInfo();
}
