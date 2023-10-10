package com.sumvibe.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import net.bytebuddy.asm.Advice;

@Data
@Accessors(chain = true) // 开启链式设置数值
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
