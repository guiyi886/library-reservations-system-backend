package com.manager.config;


import com.manager.jwt.JwtTokenUserInterceptor2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebMvcConfiguration2 implements WebMvcConfigurer {

    @Autowired
    private JwtTokenUserInterceptor2 jwtTokenUserInterceptor;

    /**
     * 注册自定义拦截器
     *
     */
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始注册自定义managers拦截器...");
        registry.addInterceptor(jwtTokenUserInterceptor)
                .addPathPatterns("/managers/**")
                .excludePathPatterns("/managers/login");
    }
}