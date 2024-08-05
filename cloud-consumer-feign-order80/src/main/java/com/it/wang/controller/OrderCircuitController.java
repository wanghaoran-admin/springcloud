package com.it.wang.controller;

import com.it.wang.apis.PayFeignApi;
import com.it.wang.resp.Result;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/feign")
public class OrderCircuitController {

    @Resource
    private PayFeignApi payFeignApi;

    /**
     * name是yml中instances下面的cloud-payment-service
     * fallbackMethod是出现异常执行的方法
     */
    @GetMapping("/pay/circuit/get/{id}")
    @CircuitBreaker(name = "cloud-payment-service", fallbackMethod = "fallback")
    public String getPayById4CircuitBreaker(@PathVariable("id") Integer id) {
        return payFeignApi.myCircuit(id);
    }

    /**
     * 舱壁
     */
    @GetMapping("/pay/circuit/get1/{id}")
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "fallback",type =Bulkhead.Type.SEMAPHORE )
    public String getPayById41CircuitBreaker(@PathVariable("id") Integer id) {
        return payFeignApi.myCircuit(id);
    }

    @GetMapping("/pay/rateLimit/get/{id}")
    @RateLimiter(name = "cloud-payment-service", fallbackMethod = "fallback4RateLimit")
    public String getPayById4RateLimit(@PathVariable("id") Integer id) {
        return payFeignApi.myRateLimit(id);
    }

    public String fallback4RateLimit(Integer id, Throwable throwable){
        return "服务器限流, 请稍后重试...";
    }


    public String fallback(Integer id, Throwable throwable){
        return "系统繁忙请稍后再试！";
    }
}
