package com.sumvibe.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DBResponse {
    private int retCode;
    private String retMsg;
    private Object data;

    public DBResponse(int retCode,String retMsg) {
        this.retCode=retCode;
        this.retMsg=retMsg;
    }
}
