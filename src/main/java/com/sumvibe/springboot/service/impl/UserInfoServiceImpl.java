package com.sumvibe.springboot.service.impl;

import com.sumvibe.springboot.dao.mysql.UserInfoDao;
import com.sumvibe.springboot.domain.User;
import com.sumvibe.springboot.domain.UserDo;
import com.sumvibe.springboot.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public List<User> getUsers() {
        List<User> users = userInfoDao.getUsers();
        return users;
    }

    @Override
    public User getUserById(String id) {
        User user = userInfoDao.getUserById(id);
        return user;
    }

    @Override
    public int addUser(User user) {
        int i = userInfoDao.addUser(user);
        log.info("插入数据结果为："+i);
        return i;
    }

    @Override
    public int batchDelUser(List<String> ids) {
        int i = userInfoDao.batchDelUser(ids);
        return i;
    }
    @Transactional(rollbackFor = ArithmeticException.class)
    @Override
    public int updateUser(String id, String name, String age, String sex, String phone) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("age", age);
        map.put("sex", sex);
        map.put("phone", phone);
        int i = userInfoDao.updateUser(map);
        return i;
    }

    @Override
    public int batchAddUser(List<UserDo> list) {
        int result = userInfoDao.batchAddUser(list);
        return result;
    }

    @Override
    public int batchDelUsers(List<UserDo> list) {
        int i = userInfoDao.batchDelUsers(list);
        return i;
    }

    // @Async注解中指定线程池任务执行器名称，即可使用该线程池执行异步任务
    @Async(value = "threadPool01")
    @Override
    public void testAsync() throws InterruptedException {
        log.info("线程【{}】开始执行...",Thread.currentThread().getName());
        //线程休眠2秒
        Thread.sleep(2000);
        log.info("线程【{}】执行结束le...",Thread.currentThread().getName());
    }

}
