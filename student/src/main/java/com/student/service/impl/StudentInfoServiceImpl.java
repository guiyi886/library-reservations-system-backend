package com.student.service.impl;

import com.student.context.BaseContext;
import com.student.mapper.StudentMapper;
import com.student.pojo.DTO.StudentDTO;
import com.student.pojo.VO.StudentInfoVO;
import com.student.service.StudentInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public StudentInfoVO getStudentInfo() {
        String id = BaseContext.getCurrentId();
        StudentInfoVO studentInfoVO = studentMapper.getInfo(id);
        return studentInfoVO;
    }

    public void modifyStudentInfo(StudentDTO studentDTO){
        String id = BaseContext.getCurrentId();
        boolean result = studentMapper.modify(studentDTO,id);
        if(result)
            log.info("修改成功");
    }
}
