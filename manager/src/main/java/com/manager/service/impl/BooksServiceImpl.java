package com.manager.service.impl;

import com.manager.entity.Book;
import com.manager.exctptions.ArriveException;
import com.manager.mapper.BookMapper;
import com.manager.service.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/18 16:20:46
 * @ClassName com.manager.service.impl.BookServiceImpl
 * @function -->
 */
@Service
@Slf4j
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    /**
     * @param bookId 实现签到业务
     */
    @Override
    public void arrive(Integer bookId) {
        Integer arrive = bookMapper.getArrive(bookId);
        if (arrive == null) {
            throw new ArriveException("未找到该条预约记录");
        } else if (arrive == 1) {
            throw new ArriveException("重复签到!");
        } else if (arrive == -1) {
            throw new ArriveException("签到失败，已超时!");
        }
        bookMapper.arrive(bookId);
    }

    @Override
    public void leave(Integer bookId) {
        Integer arrive = bookMapper.getArrive(bookId);
        if (arrive == null) {
            throw new ArriveException("未找到该条预约记录");
        } else if (arrive == 0 || arrive == -1) {
            throw new ArriveException("签退失败，未签到!");
        } else if (arrive == 2) {
            throw new ArriveException("重复签退!");
        }
        bookMapper.leave(bookId);
    }
}
