package com.student.pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoVO {
    public String stuName;
    public String stuId;
    public String stuSex;
    public String stuScore;
    public String stuPhone;
    public String stuPassword;
}
