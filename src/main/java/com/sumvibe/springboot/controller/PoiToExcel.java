package com.sumvibe.springboot.controller;

import com.sumvibe.springboot.domain.DBResponse;
import com.sumvibe.springboot.domain.StatusCode;
import com.sumvibe.springboot.domain.User;
import com.sumvibe.springboot.service.UserInfoService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.Color;
import java.io.FileOutputStream;
import java.util.List;

public class PoiToExcel {

    @Resource
    private  UserInfoService userInfoService;

    // 将数据导出为excel
    public static DBResponse dataToExcel(List<User> list) {
        DBResponse db = new DBResponse(StatusCode.RET_ERROR, "导出数据失败");
        Color color = new Color(37, 17, 206);
        //创建标题数组
        String[] titles = {"序号", "姓名", "年龄", "性别", "电话"};

        // 创建workbook 对象
        XSSFWorkbook wb = new XSSFWorkbook();
        // 创建sheet页
        XSSFSheet sheet = wb.createSheet();
        // 设置表头单元格样式
        XSSFCellStyle cs = wb.createCellStyle();
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cs.setFillForegroundColor(new XSSFColor(color));
        // 字体
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 14);
        font.setBold(true);
        cs.setFont(font);

        //设置表格首行
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(cs);
        }
        // 第五步,设置单元格样式
        XSSFCellStyle style2 = wb.createCellStyle();
        style2.setAlignment(HorizontalAlignment.CENTER);//创建一个居中格式
        // 生成字体
        Font font2 = wb.createFont();
        //设置字体大小
        font2.setFontHeightInPoints((short) 12);
        //设置字体是否加粗
        font2.setBold(false);
        // 把字体应用到当前的样式
        style2.setFont(font2);

        int rowNum = 1;
        // 写入list中的数据
        for (User user : list) {
            XSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(user.getId());
            row1.createCell(1).setCellValue(user.getName());
            row1.createCell(2).setCellValue(user.getAge());
            row1.createCell(3).setCellValue(user.getSex());
            row1.createCell(4).setCellValue(user.getPhone());
            row1.setRowStyle(style2);
            rowNum++;
        }

        db.setData(wb);
        db.setRetMsg("生成文件成功");
        db.setRetCode(StatusCode.RET_SUCCESS);
        return db;
    }

    @GetMapping("/exportExcel")
    public  void exportExcel() throws Exception {
        String fileName = "/Users/xuxufu/Desktop/"+"人员表" + System.currentTimeMillis() + ".xls";
        List<User> users = userInfoService.getUsers();
        DBResponse dbResponse = dataToExcel(users);
        XSSFWorkbook workbook = null;
        if (dbResponse.getData() != null) {
            workbook = (XSSFWorkbook) dbResponse.getData();
        }
        workbook.write(new FileOutputStream(fileName));
    }
}
