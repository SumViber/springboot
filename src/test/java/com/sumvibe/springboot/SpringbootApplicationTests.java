package com.sumvibe.springboot;
import com.sumvibe.springboot.mapper.UserInfoMapper;
import com.sumvibe.springboot.domain.User;
import com.sumvibe.springboot.domain.UserDo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;



    @Test
    void contextLoads() {

        ArrayList<UserDo> users = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            String s = UUID.randomUUID().toString().replaceAll("-", "");
            log.info("本次随机数用户ID 为：" + s);
            UserDo user = new UserDo();
            user.setName("jay"+i);
            user.setSex("男");
            user.setPhone("111");
            user.setAge(12);
            user.setId(s);
            users.add(user);
        }
        int i = userInfoMapper.batchAddUser(users);
        log.info("插入mysql数据库结果i为：" + i);
    }

    @Test
    void delAllUsers() {
        // 先查出所有数据的ID
        List<User> users = userInfoMapper.getUsers();
        // 创建集合存储id
        ArrayList<String> ids = new ArrayList<>();
        for (User user : users) {
            ids.add(user.getId());
        }
        int i = userInfoMapper.batchDelUser(ids);
        log.info("删除了 " + i + "条数据！！");
        // 再次查询数据中用户若为空 则删除成功
        List<User> users1 = userInfoMapper.getUsers();
        if (users1.size() < 1) {
            log.info("清除了所有用户数据成功！");
        }
    }

    @Test
    void getUserName() {
        String id = "2f07bae0008b430a9de72bf3eff94785";
        String userName = userInfoMapper.getUserName(id);
        System.out.println(userName);
    }

    @Test
    void saveUser() {
        User user = new User();
        user.setName("summerVibe");
        user.setSex("男");
        user.setPhone("110");
        user.setAge(50);
        int i = userInfoMapper.addUser(user);
        System.out.println("单独插入一个用户结果："+i);
    }


}
