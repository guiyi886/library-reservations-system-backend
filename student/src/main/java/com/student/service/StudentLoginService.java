package com.student.service;

import com.student.pojo.StudentAccount;

/**
 * 登录成功返回id
 */
public interface StudentLoginService {
    public String login(StudentAccount studentAccount);
}

