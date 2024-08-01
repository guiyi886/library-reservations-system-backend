package com.manager.exctptions;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guiyi
 * @date 2023/12/19 04:41:42
 * @className com.manager.exctptions.SeatException
 * @function
 */
@Data
@NoArgsConstructor
public class SeatException extends RuntimeException {

    public SeatException(String msg) {
        super(msg);
    }
}
