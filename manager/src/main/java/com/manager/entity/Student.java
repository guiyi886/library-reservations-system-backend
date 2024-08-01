package com.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    public Integer id;
    public String stuId;
    public String stuName;
    public String stuSex;
    public Integer stuScore;
    public String stuPhone;
    public String stuAddtime;
}
