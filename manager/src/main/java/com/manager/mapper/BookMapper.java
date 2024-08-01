package com.manager.mapper;

import com.manager.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/18 16:11:15
 * @ClassName com.manager.mapper.BookMapper
 * @function -->
 */
@Mapper
public interface BookMapper {

    /**
     * @return {@link List}<{@link Book}>
     * 获取所有预约记录
     */
    @Select("select * from book_tb")
    List<Book> getAllBooks();

    /**
     * @return {@link Integer}
     * 获取是否签到（0未签到/1签到/-1已超时/2已签退）
     */
    @Select("select book_arrive from book_tb where id=#{id}")
    Integer getArrive(Integer id);


    /**
     * 签到
     */
    @Select("update book_tb set book_arrive=1 where id=#{id}")
    void arrive(Integer id);

    /**
     * 签退
     */
    @Transactional      //因为有两条语句，所以开启事务回滚
    @Update("update book_tb set book_arrive=2 where id=#{bookId};" +      //更新预约记录状态为签退
            "update seat_tb set seat_state=1 " +                          //释放座位
            "where id in(select book_seat_id from book_tb where id=#{bookId})")
    void leave(Integer bookId);
}
