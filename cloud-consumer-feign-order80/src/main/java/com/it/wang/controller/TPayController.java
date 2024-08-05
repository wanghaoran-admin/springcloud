package com.it.wang.controller;


import cn.hutool.core.date.DateUtil;
import com.it.wang.apis.PayFeignApi;
import com.it.wang.entity.dto.PayDTO;
import com.it.wang.resp.Result;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 支付交易表 前端控制器
 * </p>
 *
 * @author author
 * @since 2024-07-11
 */
@RestController
@RequestMapping("feign")
public class TPayController {
    @Autowired
    private PayFeignApi payFeignApi;

    @PostMapping("/pay/add")
    public Result<Integer> addOrder(@RequestBody PayDTO payDTO){
        Result<Integer> add = payFeignApi.add(payDTO);
        return add;
    }

    @GetMapping("/pay/getById/{id}")
    public Result getPayInfo(@PathVariable("id") Integer id) {

        Result<PayDTO> byId = null;
        try {
            System.out.println("调用开始---"+ DateUtil.now());
            byId = payFeignApi.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("调用结束---"+ DateUtil.now());

        }

        return byId;
    }

    @GetMapping("/pay/Test")
    public Result Test() {
        Result<Integer> test = payFeignApi.Test();
        return test;
    }
}
