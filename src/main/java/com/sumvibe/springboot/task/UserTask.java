package com.sumvibe.springboot.task;

import com.sumvibe.springboot.domain.User;
import com.sumvibe.springboot.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @date: 2024/1/12 22:58:46
 * @author: xuxufu
 * @description:
 * 定时任务 需要加任务类加 @Component @EnableScheduling 注解，并在主启动类加上 @EnableScheduling
 */
@Slf4j
@Component
@EnableScheduling
public class UserTask {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");

    @Autowired
    private UserInfoService userInfoService;
    @Async
    @Scheduled(cron = "0/5 * * * * ?")
    public void userTask(){
        log.info(dateFormat.format(new Date())+" 当前库中数据数量: {}", userInfoService.getUsers().size());
    }

    @Async
    @Scheduled(cron = "*/2 * * * * ?")
    public void usersTask() throws InterruptedException {
        List<User> users = userInfoService.getUsers();
        for (User user : users) {
            String id = user.getId();
            userInfoService.delUserById(id);
            log.info(dateFormat.format(new Date())+" 删除用户: {}", id);
            Thread.sleep(3000);
        }
    }
}
