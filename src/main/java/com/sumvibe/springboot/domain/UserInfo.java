package com.sumvibe.springboot.domain;

import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class UserInfo {
    private Integer userId;
    private String userName;
    private Integer userAge;
    private String userSex;
    private String userPhone;
}
