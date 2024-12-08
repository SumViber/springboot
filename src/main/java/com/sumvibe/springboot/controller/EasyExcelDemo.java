package com.sumvibe.springboot.controller;

import com.alibaba.excel.EasyExcel;
import com.sumvibe.springboot.domain.UserDo;

import java.io.File;
import java.util.ArrayList;

/**
 * easyExcel 的快速上手使用
 */
public class EasyExcelDemo {
    // 测试启动方法
    public static void main(String[] args) {
        dataToExcel();
    }

    // 数据组装
    private static void dataToExcel() {
        // 组装数据
        ArrayList<UserDo> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            UserDo userDo = new UserDo(i + "", "周杰伦", 40, "男", "110");
            list.add(userDo);
        }
        // 设置文件路径
        String folderPath = "/Users/xuxufu/Desktop/excelFile";
        String filePath = "/Users/xuxufu/Desktop/excelFile/aaa.xlsx";
        File file1 = new File(folderPath);
        // 判断是否有该路径，没有就创建
        if (!file1.exists()) {
            file1.mkdirs();
        }
        EasyExcel.write(filePath, UserDo.class).sheet("用户信息表").doWrite(list);
    }
}
