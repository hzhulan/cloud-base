package com.fh.payment;

import com.alibaba.fastjson.JSONObject;
import com.fh.common.BaseTest;
import com.fh.common.MethodType;
import com.fh.common.ParamsType;
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

    @Override
    public void before() {
        super.before();

        // 如果需要使用非默认参数配置，可以使用build进行修改
        mockTestBuilder.build(ParamsType.FORM, MethodType.POST);
    }

    @Test
    public void test02() {
        String response = test("/payment/get/1");
        Payment payment = JSONObject.parseObject(response, Payment.class);

        printMsg("查询姓名校验验证");

        Assert.assertEquals("姓名校验", "彰显先", payment.getSerial());
    }

}
