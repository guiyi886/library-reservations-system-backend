package com.manager.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerAccount {
    //    private int id;
    private String managerId;   //账号
    private String managerPassword; //密码
/*    private String managerName;
    private String managerSex;
    private String managerAddtime;  //日期用String存而不是Date
    private String managerPhone;*/
}
