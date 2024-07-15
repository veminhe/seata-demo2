package org.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.entity.StorageTbl;
import org.example.mapper.StorageTblMapper;
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
@RequestMapping("/storageTbl")
public class StorageTblController {
    @Autowired
    StorageTblMapper storageTblMapper;

    @GetMapping("updateStorage")
    Object updateStorage(String commodityCode, int count){


        // 查询库存
        StorageTbl storageTbl = storageTblMapper.selectOne(new LambdaQueryWrapper<StorageTbl>().eq(StorageTbl::getCommodityCode, commodityCode));
        // 减去库存更新
        storageTbl.setCount(storageTbl.getCount()-count);
        int i = storageTblMapper.updateById(storageTbl);
        int a = 1/0;
        return storageTbl;
    }
}
