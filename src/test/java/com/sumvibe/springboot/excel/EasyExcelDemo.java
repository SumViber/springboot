package com.sumvibe.springboot.excel;

import com.alibaba.excel.EasyExcel;
import com.sumvibe.springboot.domain.User;
import com.sumvibe.springboot.domain.UserDo;
import com.sumvibe.springboot.mapper.UserInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EasyExcelDemo {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void  exportExcel() {

        // 读取数据库中的数据
        List<User> users = userInfoMapper.selectAll();
        // 导出数据为文件
        // 设置文件路径
        String folderPath = "/Users/xuxufu/Desktop/excelFile";
        String fileName = "客户信息.xlsx";
        String filePath = folderPath+"/"+fileName;
        File file1 = new File(folderPath);
        // 判断是否有该路径，没有就创建
        if (!file1.exists()) {
            file1.mkdirs();
        }

        EasyExcel.write(filePath, UserDo.class).sheet("基本信息").doWrite(users);



    }

}
