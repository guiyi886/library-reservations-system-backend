package com.manager.service;

import com.manager.entity.Book;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/18 16:13:22
 * @ClassName com.manager.service.BookService
 * @function -->
 */
public interface BooksService {
    List<Book> getAllBooks();

    void arrive(Integer Id);

    void leave(Integer bookId);
}
