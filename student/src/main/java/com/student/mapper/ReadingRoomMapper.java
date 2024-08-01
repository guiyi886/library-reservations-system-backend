package com.student.mapper;

import com.github.pagehelper.Page;
import com.student.pojo.DTO.RoomPageDTO;
import com.student.pojo.ReadingRoomSimple;
import com.student.pojo.VO.ReadingRoomSearchVO;
import com.student.pojo.VO.ReadingRoomVO;
import com.student.pojo.VO.SeatVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReadingRoomMapper {
    public Page<ReadingRoomSimple> getRoomPage(RoomPageDTO roomPageDTO);

    @Select("select id, room_name, room_state, room_type, room_create_time, room_seat_num, room_booked_seat_num, room_seat_row_num, room_seat_column_num" +
            " from room_tb" +
            " where id = #{id}")
    public ReadingRoomVO getRoomDetail(int id);

    @Select("select seat_row_id, seat_column_id, seat_state from seat_tb " +
            "where seat_position_id = #{id}")
    List<SeatVO> getSeat(int id);

    @Select("select room_name,room_seat_num,room_booked_seat_num from room_tb where room_name = #{name}")
    ReadingRoomSearchVO search(String name);

    @Select("select count(*) from room_tb")
    Integer getReadingRoomNumber();
}
