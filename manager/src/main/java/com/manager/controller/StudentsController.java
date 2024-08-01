package com.manager.controller;

import com.manager.entity.DTO.StudentDTO;
import com.manager.entity.Student;
import com.manager.entity.VO.StudentList;
import com.manager.result.Result;
import com.manager.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/managers/students")
public class StudentsController {
    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public Result getStudentsList() {
        log.info("获取学生信息列表");
        StudentList studentList = studentService.getStudentList();
        return Result.success(studentList);
    }

    @GetMapping("/single")
    public Result getStudentsSingle(@RequestParam("stu_id") int studentId) {
        log.info("获取单个学生信息, 学生id：{}", studentId);
        Student student = studentService.getStudent(studentId);
        return Result.success(student);
    }

    @DeleteMapping("/delete")
    public Result DeleteStudents(@RequestParam("id") int studentId) {
        log.info("删除学生信息, 学生id：{}", studentId);
        studentService.deleteStudent(studentId);
        return Result.success("删除成功");
    }

    @PostMapping("/change")
    public Result modifyStudentInfo(@RequestBody StudentDTO studentDTO) {
        log.info("修改学生信息：{}", studentDTO);
        studentService.modifyStudent(studentDTO);
        return Result.success("修改成功");
    }

}
