package com.fh.md.controller;

import com.fh.md.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    /**
     * kafka对接有小问题，为对接完成
     * @return
     */
    @RequestMapping("/sendMsg")
    public String sendMessage() {
        return messageProvider.send();
    }
}
