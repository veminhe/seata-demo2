package org.example.controller;

import org.example.mapper.AccountTblMapper;
import org.example.util.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    AccountTblMapper accountTblMapper;

    @Autowired
    OrderFeign testFeign;

    @GetMapping("/test")
    public Object test() {


        testFeign.test();
        return accountTblMapper.selectById("11111111");
    }
}