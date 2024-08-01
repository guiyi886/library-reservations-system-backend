package com.manager.service.impl;

import com.manager.entity.VO.SevenBookNum;
import com.manager.entity.VO.ShowPage;
import com.manager.mapper.ShowPageMapper;
import com.manager.service.ShowPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guiyi
 * @Date 2023/12/18 12:58:15
 * @ClassName com.manager.service.impl.ShowPageServiceImpl
 * @function -->返回展示页面
 */
@Slf4j
@Service
public class ShowPageServiceImpl implements ShowPageService {

    @Autowired
    private ShowPageMapper showPageMapper;

    @Override
    public ShowPage getShowPage() {
        Integer seatNumber = showPageMapper.countSeat();
        Integer roomNumber = showPageMapper.countRoom();
        Integer studentNumber = showPageMapper.countStudents();
        Integer managerNumber = showPageMapper.countManagers();
        List<SevenBookNum> sevenBookNum = showPageMapper.getWeekBook();
        return new ShowPage(seatNumber, roomNumber, studentNumber, managerNumber, sevenBookNum);
    }
}
