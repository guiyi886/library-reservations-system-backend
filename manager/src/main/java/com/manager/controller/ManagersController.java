package com.manager.controller;

import com.manager.entity.Manager;
import com.manager.entity.VO.ManagerAccount;
import com.manager.jwt.JwtProperties2;
import com.manager.jwt.JwtUtil;
import com.manager.result.Result;
import com.manager.service.impl.ManagerServiceImpl;
import com.manager.service.impl.ShowPageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/managers")
public class ManagersController {

    @Autowired
    private ManagerServiceImpl managerServiceImpl;

    @Autowired
    private JwtProperties2 jwtProperties2;

    @Autowired
    private ShowPageServiceImpl showPageImpl;

    @PostMapping("/login")
    public Result login(@RequestBody ManagerAccount managerAccount) {
        log.info("管理员登录尝试:{}", managerAccount);

        String ManagerId = managerServiceImpl.login(managerAccount);

        Map<String, Object> claims = new HashMap<>();
        claims.put("ManagerId", ManagerId);
        String token = JwtUtil.createJWT(jwtProperties2.getUserSecretKey(), jwtProperties2.getUserTtl(), claims);

        return Result.success(token, "管理员登录成功!");
    }

    @GetMapping("/showPage")
    public Result showPage() {
        log.info("返回展示页面");
        return Result.success(showPageImpl.getShowPage(), "展示页面");
    }

    @GetMapping("/single")
    public Result singleManager(@RequestParam String managerId) {
        log.info("返回管理员账户信息");
        return Result.success(managerServiceImpl.singleManager(managerId), "管理员账户信息");
    }

    @PutMapping("/change")
    public Result changeManager(@RequestBody Manager manager) {
        log.info("修改管理员账户信息");
        return Result.success(managerServiceImpl.changeManager(manager), "修改管理员账户信息");
    }
}
