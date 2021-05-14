package com.fh.common;

import com.fh.exception.BusinessRuntimeException;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @file: MockTestBuilder
 * @version: 1.0
 * @Description: mock测试builder
 * @Author: pp_lan
 * @Date: 2021/5/14
 */
public class MockTestBuilder {
    private MockMvc mockMvc;

    public MockTestBuilder() {
        WebApplicationContext webApplicationContext = SpringUtils.getBean("webApplicationContext");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        // 默认参数
        this.methodType = MethodType.GET;
        this.paramsType = ParamsType.FORM;
    }

    public MockTestBuilder(WebApplicationContext webApplicationContext) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        // 默认参数
        this.methodType = MethodType.GET;
        this.paramsType = ParamsType.FORM;
    }

    /**
     * 参数类型
     */
    private ParamsType paramsType;

    /**
     * 方法类型
     */
    private MethodType methodType;

    private MockHttpServletRequestBuilder mockHttpServletRequestBuilder;

    public MockTestBuilder build(ParamsType paramsType, MethodType methodType) {
        this.paramsType = paramsType;
        this.methodType = methodType;
        return this;
    }

    public String test(String url, String params) {
        if (StringUtils.isEmpty(url)) {
            throw new BusinessRuntimeException("请配置测试url==>setUrl");
        }

        try {
            this.mockHttpServletRequestBuilder = MockMvcRequestBuilders.get(url);
            if (params != null) {
                switch (this.paramsType.getValue()) {
                    case "application/x-www-form-urlencoded":
                        // form表单形式参数
                        this.mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
                        break;
                    case "application/json":
                        // form表单形式参数
                        this.mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_JSON).content(params);
                        break;
                    default:
                        throw new BusinessRuntimeException("暂不支持该类型参数, 查看ParamTypes确认参数类型");
                }
            }

            ResultActions perform = this.mockMvc.perform(this.mockHttpServletRequestBuilder);
            MockHttpServletResponse response = perform.andExpect(status().isOk()).andReturn().getResponse();
            response.setCharacterEncoding("utf-8");
            return response.getContentAsString();
        } catch (Exception e) {
            throw new BusinessRuntimeException("初始化异常", e);
        }
    }
}
