package com.fh.payment;

import com.alibaba.fastjson.JSONObject;
import com.fh.common.BaseTest;
import com.fh.domain.Payment;
import org.junit.Assert;
import org.junit.Test;

/**
 * @file: TestGet
 * @version: 1.0
 * @Description: 顾客查询
 * @Author: pp_lan
 * @Date: 2021/5/14
 */
public class TestGet extends BaseTest {

    @Test
    public void test02() {
        String response = test("/payment/get/1");
        Payment payment = JSONObject.parseObject(response, Payment.class);

        printMsg("查询姓名校验验证");

        Assert.assertEquals("姓名校验", "彰显先", payment.getSerial());
    }

}
