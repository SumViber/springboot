package com.sumvibe.springboot.controller;

import com.sumvibe.springboot.domain.*;
import com.sumvibe.springboot.service.UserInfoService;
import com.sumvibe.springboot.utils.MailSplitUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() throws Exception {
        List<User> users = userInfoService.getUsers();
        System.out.println(users.toString());
        return users;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public DBResponse addUser(User user) {

        DBResponse db = new DBResponse(StatusCode.RET_ERROR, "未知错误");
        int i = userInfoService.addUser(user);
        if (i == 1) {
            log.info("插入数据成功！");
            db.setRetMsg("插入数据成功");
            db.setRetCode(StatusCode.RET_SUCCESS);
        }
        return db;
    }

    @RequestMapping(value = "/batchDelUser", method = RequestMethod.GET)
    public DBResponse batchDelUser(String ids) {
        if (log.isInfoEnabled()) {
            log.info("batchDelUser input params ids:{}", ids);
        }
        DBResponse db = new DBResponse(StatusCode.RET_ERROR, "未知错误");

        try {
            String[] split = ids.split(",");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                list.add(split[i]);
            }
            int i = userInfoService.batchDelUser(list);
            log.info("批量删除用户结果为：" + i);
            User userById = userInfoService.getUserById("1");
            System.out.println("上蹿的ID是" + userById);
            if (i >= 1) {
                db.setRetMsg("批量删除用户数据成功");
                db.setRetCode(StatusCode.RET_SUCCESS);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return db;
    }


    @GetMapping("/updateUser")
    public DBResponse updateUser(String id, String name, String age, String sex, String phone) {
        DBResponse db = new DBResponse(StatusCode.RET_ERROR, "更新失败");
        int i = userInfoService.updateUser(id, name, age, sex, phone);
        User user = userInfoService.getUserById(id);
        if (i == 1 && user != null) {
            db.setRetCode(StatusCode.RET_SUCCESS);
            db.setRetMsg("更新用户信息成功");
            db.setData(user);
        }
        return db;
    }

    @GetMapping("/getUserById")
    public DBResponse getUserById(String id) {
        DBResponse db = new DBResponse(StatusCode.RET_ERROR, "查询失败");
        User user = userInfoService.getUserById(id);
        if (user != null) {
            db.setRetCode(StatusCode.RET_SUCCESS);
            db.setRetMsg("查询用户成功");
            db.setData(user);
        }
        return db;
    }

    /**
     * 批量新增用户数据
     */
    @RequestMapping(value = "/pushUser",method = RequestMethod.POST)
    public DBResponse pushUser(@RequestBody UserVO userVO) {
        DBResponse db = new DBResponse(StatusCode.RET_ERROR, "插入失败");

        // 根据类型 进行批量操作
        // 先筛选出不同类型操作的 包装为集合
        List<UserDo> addList = new ArrayList<>();
        List<UserDo> delList = new ArrayList<>();
        List<User> data = userVO.getData();
        // 变量vo对象，组装Do
        for (User user : data) {
            UserDo userDo = new UserDo();
            userDo.setId(user.getId());
            userDo.setName(user.getName());
            userDo.setAge(user.getAge());
            userDo.setSex(user.getSex());
            userDo.setPhone(user.getPhone());

            if (StringUtils.isNoneBlank(user.getOpType())){
                if ("0".equals(user.getOpType())){
                    addList.add(userDo);
                }
                if ("1".equals(user.getOpType())){
                    delList.add(userDo);
                }
            }
        }
        // 新增数据
        if (addList != null && addList.size() > 0) {
            int i = userInfoService.batchAddUser(addList);
            if (i != 0) {
                log.info("插入数据结果为：" + i);
                db.setRetCode(StatusCode.RET_SUCCESS);
                db.setRetMsg("插入成功");
            }
            return db;
        }

        // 删除数据
        if (delList != null && delList.size() >0) {
            int i = userInfoService.batchDelUsers(delList);
            if ( i >0) {
                log.info("删除数据结果为：" + i);
                db.setRetCode(StatusCode.RET_SUCCESS);
                db.setRetMsg("删除成功");
            }
        }

        List<UserDo> list = new ArrayList<>();
//        for (int i = 0; i < 1000000; i++) {
//            User user = new User(UUID.randomUUID().toString(), "小米", 10, "男", "110");
//            list.add(user);
//        }

//        long l = System.currentTimeMillis();

//        long l1 = System.currentTimeMillis();
//        long l3 = (l1 - l) / 1000;
      return db;
    }

//    @GetMapping("/batchDelUsers")
//    public DBResponse batchDelUsers() {
//        DBResponse db = new DBResponse(StatusCode.RET_ERROR, "批量删除失败");
//
//        List<User> users = userInfoService.getUsers();
//        System.out.println(users.size()+"---------");
//        String[] s = {};
//        ArrayList<Object> list = new ArrayList<>();
//
//        for (int i = 0; i < 100; i++) {
//            list.add(users.get(i).getId()) ;
//        }
//
//        String[] strings = list.toArray(s);
//        List<String> strings1 = Arrays.asList(strings);
//        System.out.println("数组元素为："+strings1.toString());
//        int i = 0;
//        try {
//            i = userInfoService.batchDelUsers(strings);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//            db.setRetCode(StatusCode.RET_SUCCESS);
//            db.setRetMsg("删除成功");
//        }
//        return db;
//    }

//    @GetMapping("/getTransInfo")
//    public DBResponse getTransInfo() {
//        DBResponse db = new DBResponse(StatusCode.RET_ERROR, "查询失败");
//        StringBuilder sbu = new StringBuilder();
//        for (int i = 0; i < 80; i++) {
//            sbu.append("<tr><td>java"+i+"</td></tr>");
//        }
//        String str = sbu.toString();
//
//        Map<String, Object> map = MailSplitUtil.dataConvert1(str);
//        log.info("map.size"+map.size());
//        if (map != null) {
//            db.setRetCode(StatusCode.RET_SUCCESS);
//            db.setRetMsg("查询交易成功！");
//            db.setData(map);
//        }
//        return db;
//    }

}
