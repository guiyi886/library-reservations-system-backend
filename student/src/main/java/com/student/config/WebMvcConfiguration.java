package com.student.config;

import com.student.interceptor.JwtTokenUserInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private JwtTokenUserInterceptor jwtTokenUserInterceptor;

    /**
     * 注册自定义拦截器
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义student拦截器...");
        registry.addInterceptor(jwtTokenUserInterceptor)
                .addPathPatterns("/student")
                .excludePathPatterns("/student/login");
    }
}