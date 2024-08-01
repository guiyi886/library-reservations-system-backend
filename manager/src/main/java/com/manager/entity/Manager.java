package com.manager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guiyi
 * @Date 2023/12/27 21:56:24
 * @ClassName com.manager.entity.Manager
 * @function -->
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    private Integer id;
    private String managerId;
    private String managerPassword;
    private String managerName;
    private String managerSex;
    private String managerAddtime;
    private String managerPhone;
}
