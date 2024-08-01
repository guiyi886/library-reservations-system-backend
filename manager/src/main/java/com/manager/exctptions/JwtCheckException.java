package com.manager.exctptions;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 令牌校验异常
 */
@Data
@NoArgsConstructor
public class JwtCheckException extends RuntimeException {

    public JwtCheckException(String msg) {
        super(msg);
    }
}
