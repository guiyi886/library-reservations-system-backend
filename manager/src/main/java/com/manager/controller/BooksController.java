package com.manager.controller;

import com.manager.result.Result;
import com.manager.service.impl.BooksServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guiyi
 * @Date 2023/12/18 16:22:36
 * @ClassName com.manager.controller.BookController
 * @function -->
 */

@RestController
@RequestMapping("/managers/books")
@CrossOrigin
@Slf4j
public class BooksController {
    @Autowired
    private BooksServiceImpl booksServiceImpl;

    @GetMapping
    public Result getAllbooks() {
        log.info("获取所有预约记录");
        return Result.success(booksServiceImpl.getAllBooks(), "所有预约记录");
    }

    @PostMapping("/arrive")
    public Result arrive(@RequestParam Integer bookId) {
        log.info("预约记录id-->" + bookId + "尝试签到");
        booksServiceImpl.arrive(bookId);
        log.info("预约记录id-->" + bookId + "签到成功");
        return Result.success(null, "签到成功");
    }

    @PostMapping("/leave")
    public Result leave(@RequestParam Integer bookId) {
        log.info("预约记录id-->" + bookId + "尝试签退");
        booksServiceImpl.leave(bookId);
        log.info("预约记录id-->" + bookId + "签退成功");
        return Result.success(null, "签退成功");
    }
}

