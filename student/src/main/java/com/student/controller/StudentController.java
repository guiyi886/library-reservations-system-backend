package com.student.controller;

import com.student.pojo.DTO.BookDTO;
import com.student.pojo.DTO.RoomPageDTO;
import com.student.pojo.DTO.StudentDTO;
import com.student.pojo.ReadingRoomPage;
import com.student.pojo.StudentAccount;
import com.student.pojo.VO.BookInfoVO;
import com.student.pojo.VO.ReadingRoomSearchVO;
import com.student.pojo.VO.ReadingRoomVO;
import com.student.pojo.VO.StudentInfoVO;
import com.student.properties.JwtProperties;
import com.student.result.Result;
import com.student.service.BookService;
import com.student.service.RoomPageService;
import com.student.service.StudentInfoService;
import com.student.service.StudentLoginService;
import com.student.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentLoginService studentLoginService;
    @Autowired
    private RoomPageService roomPageService;
    @Autowired
    private BookService bookService;

    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    public Result login(@RequestBody StudentAccount studentAccount) {
        log.info("用户登录:{}", studentAccount);

        String id = studentLoginService.login(studentAccount);

        Map<String, Object> claims = new HashMap<>();
        claims.put("UserId", id);
        String token = JwtUtil.createJWT(jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(), claims);

        return Result.success(token);
    }

    @PostMapping("/getRoomPage")
    public Result getRoomPage(@RequestBody RoomPageDTO roomPageDTO) {
        log.info("请求阅览室页面：{}", roomPageDTO);
        ReadingRoomPage readingRoomPage = roomPageService.getRoomPage(roomPageDTO);
        return Result.success(readingRoomPage);
    }

    @GetMapping("/getReadingRoom")
    public Result getDetailRoom(@RequestParam Integer id) {
        log.info("请求具体阅览室：{}", id);
        ReadingRoomVO readingRoomVO = roomPageService.getRoomDetail(id);
        return Result.success(readingRoomVO);
    }

    @PostMapping("/book")
    public Result bookSeat(@RequestBody BookDTO bookDTO) {
        log.info("预约请求：{}", bookDTO);
        bookService.bookSeat(bookDTO);
        return Result.success();
    }

    @GetMapping("/getBookingInformation")
    public Result getBookingInformation() {
        log.info("获取预约信息");
        BookInfoVO bookInfoVO = bookService.getBookInfo();
        return Result.success(bookInfoVO);
    }

    @GetMapping("/getMessage")
    public Result getStudentInfo() {
        log.info("获取当前账号学生信息");
        StudentInfoVO studentInfoVO = studentInfoService.getStudentInfo();
        return Result.success(studentInfoVO);
    }

    @PostMapping("/modify")
    public Result modifyStudentInfo(@RequestBody StudentDTO studentDTO) {
        log.info("修改当前学生信息：{}", studentDTO);
        studentInfoService.modifyStudentInfo(studentDTO);
        return Result.success();
    }

    @GetMapping("/searchRoom")
    public Result searchReadingRoom(@RequestParam String roomName) {
        log.info("搜索房间：{}", roomName);
        ReadingRoomSearchVO readingRoomSearchVO = roomPageService.searchRoom(roomName);
        return Result.success(readingRoomSearchVO);
    }

    @GetMapping("/getReadingRoomNumber")
    public Result getReadingRoomNumber() {
        log.info("获取阅览室总数");
        Integer num = roomPageService.getReadingRoomNum();
        return Result.success(num);
    }

}
