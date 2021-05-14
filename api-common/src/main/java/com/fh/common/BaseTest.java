package com.fh.common;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 * @file: BaseTest
 * @version: 1.0
 * @Description: commonTest
 * @Author: pp_lan
 * @Date: 2021/5/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTest {

    private MockTestBuilder mockTestBuilder;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Before
    public void before() {
        mockTestBuilder = new MockTestBuilder(this.webApplicationContext);
    }

    protected String test(String url) {
        return mockTestBuilder.test(url, null);
    }

    protected String test(String url, String params) {
        return mockTestBuilder.test(url, params);
    }

    protected void printMsg(String msg) {
        System.out.println(String.format("\n======================  %s  ======================\n", msg));
    }

}
