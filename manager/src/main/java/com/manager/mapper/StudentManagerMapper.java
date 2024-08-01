package com.manager.mapper;

import com.manager.entity.DTO.StudentDTO;
import com.manager.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentManagerMapper {
    @Select("select id, stu_id, stu_name, stu_sex, stu_addtime, stu_phone, stu_score " +
            "from " +
            "student_tb")
    List<Student> getStudentList();

    @Select("select id, stu_id, stu_name, stu_sex, stu_addtime, stu_phone, stu_score " +
            "from " +
            "student_tb " +
            "where id = #{id}")
    Student getStudent(int id);

    @Delete("delete from student_tb where id = #{id}")
    int deleteStudent(int id);

    int modifyStudent(StudentDTO studentDTO);
}
