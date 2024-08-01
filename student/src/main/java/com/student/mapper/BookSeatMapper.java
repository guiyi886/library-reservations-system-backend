package com.student.mapper;

import com.student.pojo.DTO.BookDTO;
import com.student.pojo.VO.BookInfoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.GetMapping;

@Mapper
public interface BookSeatMapper {
    //获取座位表id
    @Select("select id from seat_tb " +
            "where seat_position_id = #{readingRoomId} and seat_row_id = #{row} and seat_column_id = #{list}")
    int getSeatId(BookDTO bookDTO);

    @Select("select seat_state from seat_tb " +
            "where seat_position_id = #{readingRoomId} and seat_row_id = #{row} and seat_column_id = #{list}")
    int getSeatState(BookDTO bookDTO);

    //将座位表的状态改成已占用
    @Update("update seat_tb set seat_state = 1 where id = #{id}")
    void setSeatState(int id);

    //插入预约记录
    @Insert("insert ignore into book_tb(book_time, stu_id, book_seat_id, book_arrive) " +
            "value(#{time}, #{studentId}, #{seat_id}, 0)")
    boolean bookSeat(String time,String studentId,int seat_id);
    @Select("select book_time, room_tb.room_name, seat_tb.seat_row_id, seat_tb.seat_column_id, book_arrive " +
            "from book_tb " +
            "inner join seat_tb on book_tb.book_seat_id = seat_tb.id " +
            "inner join room_tb on seat_tb.seat_position_id = room_tb.id " +
            "where book_tb.stu_id = #{id}")
    BookInfoVO getBookInfo(String id);
}
