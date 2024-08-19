package com.it.controller;


import com.it.service.ITStorageService;
import com.it.wang.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-08-18
 */
@RestController
@RequestMapping("/t-storage")
public class TStorageController {
    @Resource
    private ITStorageService storageService;

    @PostMapping("/storage/decrease")
    Result<Object> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return Result.success("扣减库存成功");
    }

}
