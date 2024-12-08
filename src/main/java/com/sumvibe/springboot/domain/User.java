package com.sumvibe.springboot.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import net.bytebuddy.asm.Advice;

@Data
@Accessors(chain = true) // 开启链式设置数值
@Table("user_info")
public class User {
    @ExcelProperty("用户ID")
    @Id(keyType = KeyType.Auto)
    @Column("user_id")
    private String id;

    @ExcelProperty("姓名")
    @Column("user_name")
    private String name;

    @ExcelProperty("年龄")
    @Column("user_age")
    private Integer age;

    @ExcelProperty("性别")
    @Column("user_sex")
    private String sex;

    @ExcelProperty("电话")
    @Column("user_phone")
    private String phone;
}
