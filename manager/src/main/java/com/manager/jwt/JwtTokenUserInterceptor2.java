package com.manager.jwt;


import com.manager.context.BaseContext;
import com.manager.exctptions.JwtCheckException;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jwt令牌校验的拦截器
 */
@Component
@Slf4j
public class JwtTokenUserInterceptor2 implements HandlerInterceptor {

    @Autowired
    private JwtProperties2 jwtProperties2;

    /**
     * 校验jwt
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (true) return true;//todo:测试时关闭jwt校验

        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            log.info("放行");
            //当前拦截到的不是动态方法，直接放行
            return true;
        }

        //1、从请求头中获取令牌
        String token = request.getHeader("jwtToken");

        //2、校验令牌
        try {
            log.info("jwt校验:{}", token);
            Claims claims = JwtUtil.parseJWT(jwtProperties2.getUserSecretKey(), token);
//            System.out.println(claims);
//            String userId = String.valueOf(claims.get("UserId"));
            String ManagerId = String.valueOf(claims.get("ManagerId"));
            log.info("当前管理员的id:{}", ManagerId);
            BaseContext.setCurrentId(ManagerId);
            //3、通过，放行
            return true;
        } catch (Exception ex) {

            //4、不通过，响应401状态码
            response.setStatus(401);
            throw new JwtCheckException("jwt校验失败");
        }
    }
}
