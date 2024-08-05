package com.it.wang.controller;

import cn.hutool.core.util.IdUtil;
import com.it.wang.apis.PayFeignApi;
import com.it.wang.entity.TPay;
import com.it.wang.entity.dto.PayDTO;
import com.it.wang.resp.Result;
import com.it.wang.service.ITPayService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/gateway")
public class OrderGatewayController {
    @Resource
    private ITPayService payService;


    @GetMapping("/pay/get/{id}")
    public Result<TPay> getPayById(@PathVariable("id") Integer id) {
        TPay byId = payService.getById(id);
        return Result.success(byId);
    }

    @GetMapping("/pay/getInfo")
    public Result<String> getInfo() {
        return Result.success(IdUtil.simpleUUID());
    }

}
