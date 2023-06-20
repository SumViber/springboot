package com.sumvibe.springboot.service.impl;

import com.sumvibe.springboot.dao.mysql.UserInfoDao;
import com.sumvibe.springboot.domain.User;
import com.sumvibe.springboot.domain.UserDo;
import com.sumvibe.springboot.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
