package com.manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * @author guiyi
 * @Date 2023/12/18 18:58:20
 * @ClassName com.manager.mapper.everyDayUpdateMapper
 * @function -->
 */
@Mapper
public interface SchedulerUpdateMapper {

    /**
     * 扣前一天内超时的人5分
     */
    @Update("update student_tb set stu_score = stu_score-5 " +
            "where stu_id in (select stu_id from book_tb where book_arrive = -1 " +
            "and book_time BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW())")
    void subScoreFive();

    /**
     * 每人加一分
     */
    @Update("update student_tb " +
            "set stu_score=stu_score+1 " +
            "where stu_id in (select stu_id from " +
            "                                   (select stu_id from student_tb where stu_score<100) AS temp_tb)")
    void addScoreOne();

    /**
     * 若超过一小时则设为超时
     */
    @Update("update book_tb set  book_arrive=-1 where DATE_SUB(now(),INTERVAL 1 hour) > book_time " +  //超过一小时
            "and book_time BETWEEN DATE_SUB(NOW(), INTERVAL 1 DAY) AND NOW() " +    //范围为当天
            "and book_arrive = 0")
    //排除已签到过的，避免影响到已签到的记录
    void updateArrive();
}
