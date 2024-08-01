package com.manager.service;

import com.manager.entity.Manager;
import com.manager.entity.VO.ManagerAccount;

public interface ManagerService {
    String login(ManagerAccount managerAccount);

    Manager singleManager(String managerId);

    Manager changeManager(Manager manager);
}
