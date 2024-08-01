package com.manager.service.impl;

import com.manager.entity.Manager;
import com.manager.entity.VO.ManagerAccount;
import com.manager.exctptions.ManagertException;
import com.manager.mapper.ManagerMapper;
import com.manager.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public String login(ManagerAccount managerAccount) {
        String managerId = managerMapper.login(managerAccount);
        if (managerId == null) {
            throw new ManagertException("管理员登录失败，账号或密码错误！！！");
        }
        return managerId;
    }

    @Override
    public Manager singleManager(String managerId) {
        return managerMapper.singleManager(managerId);
    }

    @Override
    public Manager changeManager(Manager manager) {
        if (managerMapper.changeManager(manager) == false) {
            throw new ManagertException("管理员信息修改失败！！！");
        }
        return managerMapper.singleManager(manager.getManagerId());
    }
}
