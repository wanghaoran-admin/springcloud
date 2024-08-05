package com.it.wang.controller;

import com.it.wang.entity.dto.PayDTO;
import com.it.wang.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://cloud-payment-service";

    @PostMapping("/pay/add")
    public Result addOrder(@RequestBody PayDTO payDTO) {
        System.out.println(payDTO);
        return restTemplate.postForObject(PAYMENT_URL + "/pay/add", payDTO, Result.class);
    }



    @GetMapping("/pay/getById/{id}")
    public Result getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/getById/" + id, Result.class, id);
    }



    @GetMapping("/pay/getAll")
    public Result getPayListInfo() {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/getAll", Result.class);
    }
}
