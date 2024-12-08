package com.sumvibe.springboot.flexdemo;

import com.mybatisflex.core.query.QueryWrapper;
import com.sumvibe.springboot.domain.User;
import com.sumvibe.springboot.mapper.AccountMapper;
import com.sumvibe.springboot.mapper.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlexInsertDemo {

    private static final Logger log = LoggerFactory.getLogger(FlexInsertDemo.class);
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    // 插入一个对象
    @Test
    public void testInsert() {
        User user = new User()
                .setAge(89)
                .setSex("男")
                .setName("xxf")
                .setPhone("166");
        // 创建wrapper
        int result = userInfoMapper.insert(user);
        if (result == 1) {
            log.info("插入数据成功，结果为{}",result);
        } else {
            log.info("插入数据失败！");
        }
    }

    // 部分字段添加
    @Test
    public void insertPart() {
        User user = new User()
                .setName("sumvibe");
        // 创建wrapper
        //int result = userInfoMapper.insertSelective(user);
        int result = userInfoMapper.insert(user);
        if (result == 1) {
            log.info("插入数据成功，结果为{}",result);
        } else {
            log.info("插入数据失败！");
        }
    }

    // 插入或者更新 检查主键，若有则更新
    @Test
    public void insertOrUpdate() {
        User user = new User()
                .setId("528")
                .setAge(34)
                .setSex("man")
                .setPhone("166099");
        int i = userInfoMapper.insertOrUpdate(user,true);
        log.info("result :{}",i);
        User user1 = userInfoMapper.selectOneById("528");
        log.info(user1.toString());
    }

    // 批量插入多个对象
    @Test
    public void testBatchInsert() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            userList.add(new User().setAge(i).setSex("男").setName("mcsr").setPhone("008"+i));
        }
        int i = userInfoMapper.insertBatch(userList);
        log.info("批量插入数据成功，插入数量: {}", i);
    }
}
