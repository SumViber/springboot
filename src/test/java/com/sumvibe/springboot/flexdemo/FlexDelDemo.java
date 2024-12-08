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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlexDelDemo {

    private static final Logger log = LoggerFactory.getLogger(FlexDelDemo.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    //根据主键删除
    @Test
    public void delById() {
        int i = userInfoMapper.deleteById(120732);
        log.info("delete res: {}", i);
    }

    @Test
    public void delByIds() {
        int[] ids = {120729,120730,120731};
        int i = userInfoMapper.deleteById(new int[]{120729,120730,120731});
        log.info("delete res1: {}", i);
    }

    // 根据 queryWrapper 构建查询条件
    @Test
    public void testDelByQw() {
        QueryWrapper queryWrapper = QueryWrapper.create();
        queryWrapper.where("user_name='mcsr'");
        int result = userInfoMapper.deleteByQuery(queryWrapper);
        log.info("delete result: {}", result);
    }

    @Test
    public void testDelByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "mcsr");
        int j = userInfoMapper.deleteByMap(map);
        log.info("del result: {}", j);
    }

    //
}
