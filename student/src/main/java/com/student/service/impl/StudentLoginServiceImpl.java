package com.student.service.impl;

import com.student.exctptions.AccountException;
import com.student.mapper.LoginMapper;
import com.student.pojo.StudentAccount;
import com.student.service.StudentLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户登录
 */
@Slf4j
@Service
public class StudentLoginServiceImpl implements StudentLoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public String login(StudentAccount studentAccount) {
        String id = loginMapper.login(studentAccount);
        if(id == null){
            throw new AccountException("用户登录失败，账号或密码错误！！！");
        }
        return id;
    }

}
