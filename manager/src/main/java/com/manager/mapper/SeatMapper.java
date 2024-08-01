package com.manager.mapper;

import com.manager.entity.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/19 16:37:59
 * @ClassName com.manager.mapper.SeatMapper
 * @function -->
 */
@Mapper
public interface SeatMapper {

    /**
     * @date 2023/12/19 05:02:51
     * @function -->获取作为状态
     */
    @Select("select seat_state from seat_tb where id = #{seatId}")
    Integer getState(Integer seatId);

    /**
     * @date 2023/12/19 05:03:00
     * @function -->取反座位状态
     */
    @Update("update seat_tb set seat_state = case when seat_state=0 then 1 else 0 end where id = #{seatId}")
    Integer reState(Integer seatId);

    @Select("select * from seat_tb where seat_position_id = #{seatPositionId}")
    List<Seat> getSeatAll(Integer seatPositionId);
}
