package com.manager.shleduer;

import com.manager.mapper.SchedulerUpdateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author guiyi
 * @Date 2023/12/18 20:13:14
 * @ClassName com.manager.shleduer.UpdateBook
 * @function -->
 */
@Slf4j
@Component
public class UpdateBook {

    @Autowired
    private SchedulerUpdateMapper schedulerUpdateMapper;

    /**
     * 每天0点更新分数，先扣超时的名单的5分，再所有人加1分（上限100分）
     */
    @Scheduled(cron = "0 0 0 * * ?") // 在每天0点触发
//    @Scheduled(cron = "0/5 * * * * ?") // 测试，每五秒一次
    public void everyDayUpdateScore() {
        log.info("执行定时任务 --> 每天0点更新学生分数");
        schedulerUpdateMapper.subScoreFive();
        schedulerUpdateMapper.addScoreOne();
    }

    /**
     * 每分钟扫描一次预约记录，若超时则将book_arrive设置为-1
     */
    @Scheduled(cron = "0 * * * * *") // 每分钟执行一次
//    @Scheduled(cron = "0/5 * * * * ?") // 测试，每五秒一次
    public void everyAHourUpdateArrive() {
        log.info("执行定时任务 --> 每分钟更新预约状态");
        schedulerUpdateMapper.updateArrive();
    }
}
