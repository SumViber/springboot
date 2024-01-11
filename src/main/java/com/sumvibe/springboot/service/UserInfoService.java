package com.sumvibe.springboot.service;

import com.sumvibe.springboot.domain.User;
import com.sumvibe.springboot.domain.UserDo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserInfoService {
    /**
     * 获取所有的用户信息
     * @return
     */
    List<User> getUsers();

    User getUserById(String id);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);

    int batchDelUser(List<String> ids);

    int updateUser(String id,String name,String age,String sex,String phone);

    int batchAddUser(List<UserDo> list);

    int batchDelUsers(List<UserDo> list);

    // 测试异步方法
    void testAsync() throws InterruptedException;

}
