package com.sumvibe.springboot;

import com.sumvibe.springboot.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @date: 2023/12/4 11:14:30
 * @author: xuxufu
 * @description:
 * Spring Boot应用程序中使用 @RunWith(SpringRunner.class) 注解来执行单元测试，
 * 以便在测试期间使用Spring容器和Spring的依赖注入等功能
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ThreadTest {

    @Resource
    private UserInfoService userInfoService;
    @Test
    public void test() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            userInfoService.testAsync();
        }
        TimeUnit.SECONDS.sleep(3);
    }
}
