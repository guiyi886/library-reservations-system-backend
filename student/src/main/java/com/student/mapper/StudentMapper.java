package com.student.mapper;

import com.student.pojo.DTO.StudentDTO;
import com.student.pojo.VO.StudentInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {
    @Select("select stu_name, stu_id, stu_sex, stu_score, stu_phone, stu_password " +
            "from student_tb " +
            "where stu_id = #{id}")
    StudentInfoVO getInfo(String id);

    @Update("update student_tb set stu_name = #{studentDTO.name}, stu_sex = #{studentDTO.sex}, stu_phone = #{studentDTO.phone} " +
            "where stu_id = #{id}")
    boolean modify(StudentDTO studentDTO,String id);
}
