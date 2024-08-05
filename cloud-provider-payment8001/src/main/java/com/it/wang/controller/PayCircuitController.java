package com.it.wang.controller;


import cn.hutool.core.util.IdUtil;
import com.it.wang.resp.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class PayCircuitController {
    @GetMapping("/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("Id不能为负数 ... ");
        }

        if (id == 9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "Hello" + id + IdUtil.simpleUUID();
    }

    @GetMapping("/pay/rateLimit/{id}")
    public String myRateLimit(@PathVariable("id") Integer id) {
        return "Hello" + id + IdUtil.simpleUUID();
    }
}
