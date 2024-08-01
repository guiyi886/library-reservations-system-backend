package com.student.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录账户
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentAccount {
    public String account;
    public String password;
}
