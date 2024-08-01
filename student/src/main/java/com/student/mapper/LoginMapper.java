package com.student.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.student.pojo.StudentAccount;
import org.springframework.stereotype.Repository;

@Mapper
public interface LoginMapper {
    @Select("select stu_id from student_tb where stu_id = #{account} and stu_password = #{password}")
    String login(StudentAccount studentAccount);
}
