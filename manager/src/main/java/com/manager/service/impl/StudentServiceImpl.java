package com.manager.service.impl;

import com.manager.entity.DTO.StudentDTO;
import com.manager.entity.Student;
import com.manager.entity.VO.StudentList;
import com.manager.mapper.StudentManagerMapper;
import com.manager.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentManagerMapper studentManagerMapper;


    @Override
    public StudentList getStudentList() {
        List<Student> list = studentManagerMapper.getStudentList();
        StudentList studentList = new StudentList(list.size(), list);
        return studentList;
    }

    @Override
    public Student getStudent(int id) {
        Student student = studentManagerMapper.getStudent(id);
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        int ans = studentManagerMapper.deleteStudent(id);
        if(ans >= 1)
            log.info("删除成功");
        else
            log.info("删除失败");
    }

    @Override
    public void modifyStudent(StudentDTO studentDTO) {
        int ans = studentManagerMapper.modifyStudent(studentDTO);
        if(ans!=0)
            log.info("修改成功");
        else
            log.info("修改失败");
    }


}
