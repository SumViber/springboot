package com.sumvibe.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String name;
    private Integer age;
    private String sex;
    private String phone;
    /**
     * 操作类型 0-新增 1-删除
     */
    private String opType;
}
