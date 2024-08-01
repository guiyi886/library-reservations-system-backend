package com.student.service.impl;

import com.student.context.BaseContext;
import com.student.exctptions.BookFailException;
import com.student.mapper.BookSeatMapper;
import com.student.pojo.DTO.BookDTO;
import com.student.pojo.VO.BookInfoVO;
import com.student.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.student.context.BaseContext.getCurrentId;

/**
 * 预约座位：
 * 1、添加预约记录
 * 2、更改座位表可用信息
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Autowired
    BookSeatMapper bookSeatMapper;

    @Override
    public void bookSeat(BookDTO bookDTO) {
        //验证座位状态
        if(bookSeatMapper.getSeatState(bookDTO) == 1){
            throw new BookFailException("座位已被预约");
        }

        //更改座位表中座位信息
        int id = bookSeatMapper.getSeatId(bookDTO);
        bookSeatMapper.setSeatState(id);
        log.info("获取座位id：{}", id);

        //获取插入时间
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatTime = currentTime.format(formatter);
        log.info("获取当前时间：{}",formatTime);

        //获取学生id
        String stuId = getCurrentId();
        stuId = "2023451164";//todo:因为关闭了令牌，没办法得到用户id，因此手动赋值
        boolean ans = bookSeatMapper.bookSeat(formatTime, stuId, id);
        if(ans)
            log.info("预约成功");
        else{
            throw new BookFailException("预约失败");
        }
    }

    /**
     * 获取个人预约信息
     * @return
     */
    public BookInfoVO getBookInfo(){
        String stuId = BaseContext.getCurrentId();
        stuId = "2023451164";//测试用例
        BookInfoVO bookInfoVO = bookSeatMapper.getBookInfo(stuId);
        log.info("获取预约信息：{}", bookInfoVO);
        return bookInfoVO;
    }
}
