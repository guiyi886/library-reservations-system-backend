package com.manager.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "library.jwt")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtProperties2 {

    /**
     * 生成jwt令牌相关配置
     */
    private String userSecretKey;
    private long userTtl;
//    private String userTokenName;

}
