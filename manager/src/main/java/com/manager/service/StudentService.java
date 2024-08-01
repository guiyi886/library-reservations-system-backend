package com.manager.service;

import com.manager.entity.DTO.StudentDTO;
import com.manager.entity.Student;
import com.manager.entity.VO.StudentList;

public interface StudentService {
    StudentList getStudentList();

     Student getStudent(int id);

     void deleteStudent(int id);

     void modifyStudent(StudentDTO studentDTO);
}
