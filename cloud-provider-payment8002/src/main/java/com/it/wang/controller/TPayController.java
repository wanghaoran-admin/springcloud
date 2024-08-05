package com.it.wang.controller;


import com.it.wang.entity.TPay;
import com.it.wang.resp.Result;
import com.it.wang.service.ITPayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@Tag(name = "支付微服务模块",description = "支付CRUD")
@RequestMapping("/pay")
public class TPayController {
    @Autowired
    private ITPayService itPayService;

    @PostMapping("add")
    @Operation(summary = "新增",description = "新增支付流水方法,对象作为参数")
    public Result<Boolean> add(@RequestBody TPay tPay){
        System.out.println(tPay);
        boolean save = itPayService.save(tPay);
        return Result.success(save);
    }



    @DeleteMapping("delete/{id}")
    public Result<Boolean> add(@PathVariable("id") Integer id){
        System.out.println(id);
        boolean remove = itPayService.removeById(id);
        return Result.success(remove);
    }



    @PutMapping("update")
    public Result<Boolean> update(TPay tPay){
        System.out.println(tPay);
        boolean b = itPayService.updateById(tPay);
        return Result.success(b);
    }

    @Value("${server.port}")
    Integer port;

    @GetMapping("getById/{id}")
    public Result<TPay> getById(@PathVariable("id") Integer id){
        System.out.println(port);
        TPay byId = itPayService.getById(id);
        return Result.success(byId);
    }


    @GetMapping("getAll")
    public Result<List<TPay>> getAll(){
        return Result.success(itPayService.list());
    }


    @GetMapping("Test")
    public Result<Integer> Test(){
        return Result.success(port);
    }



}
