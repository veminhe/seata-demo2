package org.example.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "seata-service-order")
public interface OrderFeign {


    @GetMapping("/test")
    void test();

    @GetMapping("orderTbl/insertOrder")
    Object insertOrder(@RequestParam String userId, @RequestParam  String commodityCode, @RequestParam  int count, @RequestParam  int money);

}
