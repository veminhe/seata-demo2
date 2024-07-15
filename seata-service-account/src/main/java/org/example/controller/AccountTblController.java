package org.example.controller;


import io.seata.spring.annotation.GlobalTransactional;
import org.example.entity.AccountTbl;
import org.example.mapper.AccountTblMapper;
import org.example.service.IAccountTblService;
import org.example.util.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author heming
 * @since 2024-07-12
 */
@RestController
@RequestMapping("/accountTbl")
public class AccountTblController {

    @Autowired
    IAccountTblService accountTblService;

    @GetMapping("/all")
    public Object test() {
        return accountTblService.list();
    }

    @Autowired
    AccountTblMapper accountTblMapper;

    @Autowired
    OrderFeign orderFeign;

    @GlobalTransactional
    @GetMapping("/insertOrder")
    public Object insertOrder() {


        // 查询用户
        AccountTbl accountTbl = accountTblMapper.selectById("11111111");
        // 下单
        Object order = orderFeign.insertOrder(accountTbl.getUserId(), "iphone11", 1, 1);
        // 修改余额
        accountTbl.setMoney(accountTbl.getMoney() - 1);
        accountTblMapper.updateById(accountTbl);
        return order;
    }
}
