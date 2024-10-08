package com.it.controller;

import com.it.service.FlowLimitService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class FlowLimitController {

    @Autowired
    private FlowLimitService flowLimitService;

    @GetMapping("/testA")
    public String testA() {
        return "into ... A ...";
    }

    @GetMapping("/testB")
    public String testB() {
        return "into ... B ...";
    }

    @GetMapping("/testC")
    public String testC() {
        flowLimitService.common();
        return "into ... C ...";
    }

    @GetMapping("/testD")
    public String testD() {
        flowLimitService.common();
        return "into ... D ...";
    }

    @GetMapping("/testF")
    public String testF() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("熔断测试, 慢调用比例");
        return "into ... F ...";
    }
}
