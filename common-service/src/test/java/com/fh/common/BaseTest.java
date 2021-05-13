package com.fh.common;

import com.fh.domain.Payment;
import com.fh.exception.BusinessRuntimeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Autowired
    private TestRestTemplate restTemplate;

    @Resource
    private MockMvc mockMvc;

    @Test
    public void testScore(){

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/payment/get/1")).andExpect(status().isOk());

            Payment content = this.restTemplate.getForObject("/payment/get/1", Payment.class);
            System.out.println(content);
        } catch (Exception e) {
            throw new BusinessRuntimeException("初始化异常:\n" + e.getMessage());
        }
    }
}
