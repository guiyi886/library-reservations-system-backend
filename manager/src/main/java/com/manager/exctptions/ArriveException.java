package com.manager.exctptions;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guiyi
 * @Date 2023/12/18 17:41:34
 * @ClassName com.manager.exctptions.ArriveException
 * @function -->
 */
@Data
@NoArgsConstructor
public class ArriveException extends RuntimeException {
    public ArriveException(String msg) {
        super(msg);
    }
}
