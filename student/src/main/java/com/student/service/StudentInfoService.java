package com.student.service;

import com.student.pojo.DTO.StudentDTO;
import com.student.pojo.VO.StudentInfoVO;

public interface StudentInfoService {
    StudentInfoVO getStudentInfo();

    void modifyStudentInfo(StudentDTO studentDTO);
}
