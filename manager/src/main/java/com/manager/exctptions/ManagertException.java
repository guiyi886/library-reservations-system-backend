package com.manager.exctptions;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录失败异常
 */
@Data
@NoArgsConstructor
public class ManagertException extends RuntimeException {

    public ManagertException(String msg) {
        super(msg);
    }
}
