package com.sumvibe.springboot.dao.mysql;

import com.sumvibe.springboot.domain.User;
import com.sumvibe.springboot.domain.UserDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoDao {
    /**
     * 查询数据
     * @return
     */
    List<User> getUsers();


    User getUserById(String id);

    /**
     * 插入数据
     */
    int addUser(User user);

    /**
     * 批量删除数据
     * @param ids
     * @return
     */
    int batchDelUser(List<String> ids);

    int updateUser(Map<String,Object> params);

    /**
     * 批量插入用户
     * @param list
     * @return
     */
    int batchAddUser(List<UserDo> list);

    /**
     * 批量删除
     * @param
     * @return
     */
    int batchDelUsers(List<UserDo> list);

    String getUserName(String id);
}
