package com.manager.exctptions;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guiyi
 * @date 2023/12/19 04:14:47
 * @className com.manager.exctptions.RoomException
 * @function 阅览室相关异常
 */
@Data
@NoArgsConstructor
public class RoomException extends RuntimeException {

    public RoomException(String msg) {
        super(msg);
    }
}
