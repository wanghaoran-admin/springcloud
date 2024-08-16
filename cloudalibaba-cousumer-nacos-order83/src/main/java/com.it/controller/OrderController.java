package com.it.controller;

import com.it.wang.apis.PayFeignSentinelApi;
import com.it.wang.entity.dto.PayDTO;
import com.it.wang.resp.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private PayFeignSentinelApi payFeignSentinelApi;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/order/pay/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serverURL + "/pay/nacos/" + id, String.class);
    }


    @GetMapping("/consume/pay/nacos/get/{orderNo}")
    Result<PayDTO> getPayByOrderNo(@PathVariable("orderNo") String orderNo){
        return payFeignSentinelApi.getPayByOrderNo(orderNo);
    }

}
