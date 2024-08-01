package com.manager.mapper;

import com.manager.entity.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/19 15:55:54
 * @ClassName com.manager.mapper.RoomMapper
 * @function -->
 */
@Mapper
public interface RoomMapper {

    /**
     * @date 2023/12/19 04:02:25
     * @function -->  获取阅览室信息
     */
    @Select("select * from room_tb where id = #{roomId}")
    Room getRoom(Integer roomId);

    /**
     * @date 2023/12/20 09:56:32
     * @function --> 删除阅览室信息
     */
    @Delete("delete from room_tb where id = #{roomId}")
    Integer deleteRoom(Integer roomId);

    @Select("select * from room_tb")
    List<Room> getRoomAll();

    @Insert("insert into room_tb " +
            "(room_name, room_state, room_type, room_create_time, room_seat_num, " +
            "room_booked_seat_num, room_seat_row_num, room_seat_column_num) " +
            "values " +
            "(#{roomName}, #{roomState}, #{roomType}, #{roomCreateTime}, #{roomSeatNum}, " +
            "#{roomBookedSeatNum}, #{roomSeatRowNum}, #{roomSeatColumnNum})")
    void createRoom(Room room);

    @Update("update room_tb set room_state = case room_state when 1 then 0 else 1 end where id = #{roomId}")
    void changeRoomState(Integer roomId);
}
