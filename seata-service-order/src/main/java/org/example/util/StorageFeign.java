package org.example.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "seata-service-storage")
public interface StorageFeign {


    @GetMapping("/storageTbl/updateStorage")
    Object updateStorage(@RequestParam String commodityCode, @RequestParam  int count);
}
