package org.example.controller;


import org.example.entity.OrderTbl;
import org.example.mapper.OrderTblMapper;
import org.example.util.StorageFeign;
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
@RequestMapping("/orderTbl")
public class OrderTblController {


    @Autowired
    OrderTblMapper orderTblMapper;
    @Autowired
    StorageFeign storageFeign;

    @GetMapping("insertOrder")
    public Object insertOrder(String userId, String commodityCode, int count, int money) {


        // 下定单
        OrderTbl orderTbl = new OrderTbl();
        orderTbl.setUserId(userId);
        orderTbl.setCommodityCode(commodityCode);
        orderTbl.setCount(count);
        orderTbl.setMoney(1);
        // 下订单扣库存
        orderTblMapper.insert(orderTbl);
        Object storage = storageFeign.updateStorage(commodityCode, count);
        return orderTbl;
    }
}
