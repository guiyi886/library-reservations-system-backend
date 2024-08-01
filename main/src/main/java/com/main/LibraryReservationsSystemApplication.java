package com.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication          // 启动类
@ComponentScan(basePackages = {"com.student", "com.manager"}) // 扫描包
@EnableTransactionManagement    // 开启事务
@EnableConfigurationProperties  // 开启配置文件
@MapperScan("com.**.mapper")    // 指定要扫描的Mapper类的包的路径
@EnableScheduling               // 开启定时任务
public class LibraryReservationsSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryReservationsSystemApplication.class, args);
    }

}
