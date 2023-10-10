package com.sumvibe.springboot;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import com.sumvibe.springboot.domain.User;
import com.sumvibe.springboot.domain.UserInfo;
import com.sumvibe.springboot.utils.Tools;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;


/**
 * @date: 2023/6/29 00:07:58
 * @author: xuxufu
 * @description:
 */
@SpringBootTest
@Slf4j
public class Test02 {

    @Test
    public void test() {
        int i = 0;
        String str = "";
//        do {
//            str = getStr();
//            System.out.println(str);
//            i++;
//            System.out.println(i);
//        } while (!str.contains("."));
        for (int j = 0; j < 1000000; j++) {
            str = getStr();
            i++;
            System.out.println("第 "+i+"次输出字符串："+str);
            System.out.println("-------------------");
        }
    }

    public static String getStr() {
        String orderNo;
        String trandNo;
        int j = 0;
        do {
            trandNo = String.valueOf((Math.random() * 9 + 1));
            orderNo = trandNo.substring(trandNo.length() - 12);
            System.out.println("原始trandNo: " + trandNo);
            System.out.println("trandNo原始长度："+trandNo.length());
            j++;
        } while (orderNo.contains("."));
        //trandNo = String.valueOf((Math.random() * 9 + 1));
        String sdf = new SimpleDateFormat("yyMMdd").format(new Date());
        System.out.println("最终trandNo: " + trandNo);
        System.out.println("trandNo最终长度：" + trandNo.length());
        System.out.println("循环次数j："+j);
        return sdf + orderNo;
    }

    public static Long getUUIDNumber() {
        String orderNo;
        Random random = new Random();
        String trandNo = String.valueOf(random.nextInt(9) + 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        orderNo = trandNo + sdf.format(new Date());
        return Long.valueOf(orderNo);
    }

    @Test
    public void test01() {
     // 生成固定位数的随机数
        Random random = new Random();
        int i = random.nextInt();
        System.out.println(i);

    }

    @Test
    public void test02() {
        long now = new Date().getTime();
        for (int i = 0; i < 100; i++) {
            Ulid monotonicUlid = UlidCreator.getMonotonicUlid();
            System.out.println(i+" times get ulid: "+monotonicUlid.toString());
        }
    }

    @Test
    public void test03() {
        Ulid monotonicUlid = UlidCreator.getMonotonicUlid();

        Ulid monotonicUlid1 = UlidCreator.getMonotonicUlid();

        int i = monotonicUlid.compareTo(monotonicUlid1);
        System.out.println(i);

    }

    // 测试hutool-json

    @Test
    public void json() {

        // 对象bean -- json字符串
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(1)
                .setUserName("jay")
                .setUserSex("nan")
                .setUserAge(20)
                .setUserPhone("18827718");
        String jsonStr = JSONUtil.toJsonStr(userInfo);
        System.out.println(jsonStr);

        HashMap<Object, Object> map = new HashMap<>();
        map.put("user", userInfo);
        String jsonStr1 = JSONUtil.toJsonStr(map);
        System.out.println(jsonStr1);

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(userInfo);
        System.out.println(JSONUtil.toJsonStr(objects));

        // 获取格式化后的json
        System.out.println(JSONUtil.toJsonPrettyStr(map));

        // json字符串解析
        JSONObject user = JSONUtil.parseObj(userInfo);
        String userName = user.getStr("userName");
        System.out.println(userName);

        // json字符串转化为bean
        String str = "{\"userId\":1,\"userName\":\"jay\",\"userAge\":20,\"userSex\":\"nan\",\"userPhone\":\"18827718\"}";
        UserInfo bean = JSONUtil.toBean( str, UserInfo.class);
        System.out.println(bean.getUserSex());




    }
}
