package com.manager.mapper;

import com.manager.entity.VO.SevenBookNum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/18 13:55:43
 * @ClassName com.manager.mapper.ShowPageMapper
 * @function -->
 */
@Mapper
public interface ShowPageMapper {

    @Select("select count(*) from seat_tb")
    Integer countSeat();

    @Select("select count(*) from room_tb")
    Integer countRoom();

    @Select("select count(*) from student_tb")
    Integer countStudents();

    @Select("select count(*) from manager_tb")
    Integer countManagers();

    //    @Select("SELECT * FROM book_tb WHERE book_time BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW()")
    @Select("SELECT DATE(book_time) AS book_date, COUNT(*) AS book_num\n" +
            "FROM book_tb\n" +
            "WHERE book_time BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW()\n" +
            "GROUP BY book_date\n" +
            "ORDER BY book_date;")
    List<SevenBookNum> getWeekBook();
}
