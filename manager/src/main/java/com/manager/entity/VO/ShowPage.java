package com.manager.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/18 12:47:30
 * @ClassName com.manager.entity.VO.ShowPage
 * @function -->
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowPage {
    /**
     * 座位数
     */
    private Integer seatNumber;

    /**
     * 阅览室数
     */
    private Integer roomNumber;

    /**
     * 学生人数
     */
    private Integer studentNumber;

    /**
     * 管理员人数
     */
    private Integer managerNumber;

    /**
     * 七天内每天预定数
     */
    private List<SevenBookNum> weekBookList;

}
