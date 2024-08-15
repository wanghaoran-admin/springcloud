package com.it.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RateLimitController {
    @GetMapping("/rateLimitByUrl")
    public String rateLimitByUrl() {
        return "未使用注解";
    }

    @GetMapping("/rateLimitByResource")
    @SentinelResource(value = "ByResource", blockHandler = "byResourceHandler")
    public String rateLimitByResource() {
        return "进入了rateLimitByResource控制器";
    }


    @GetMapping("ce1/{shu}")
    @SentinelResource(value = "ce",blockHandler = "byResourceHandler",fallback = "byFallback")
    public String ce1(@PathVariable("shu") String shu){

        if (Integer.parseInt(shu)==0){
            throw new  RuntimeException();
        }
        System.out.println(shu);
        return shu;
    }

    public String byFallback(@PathVariable("shu") String shu, Throwable throwable) {
        return "逻辑异常, 这是自定义返回的字符串";
    }


    public String byResourceHandler(@PathVariable("shu") String shu,BlockException blockException) {
        return "限流了..........";
    }



    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "handleBlock")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "testHotKey ...";
    }

    public String handleBlock(String p1, String p2, BlockException ex) {
        return "Request blocked due to flow control";
    }
}
