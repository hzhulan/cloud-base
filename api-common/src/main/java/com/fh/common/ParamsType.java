package com.fh.common;

/**
 * @file: ParamsType
 * @version: 1.0
 * @Description: 参数传递方式
 * @Author: pp_lan
 * @Date: 2021/5/14
 */
public enum  ParamsType {
    FORM("application/x-www-form-urlencoded"), JSON("application/json");

    private String value;

    ParamsType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
