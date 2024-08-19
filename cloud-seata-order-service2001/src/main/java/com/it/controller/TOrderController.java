package com.it.controller;


import com.it.entity.TOrder;
import com.it.service.ITOrderService;
import com.it.wang.resp.Result;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/t-order")
public class TOrderController {
    @Resource
    private ITOrderService orderService;

    @GetMapping("/order/create")
    @GlobalTransactional(name = "create-order-transaction", rollbackFor = Exception.class)
    public Result<TOrder> create(TOrder order) {

        System.out.println("这里是接受的数据："+order);
        orderService.create(order);
        return Result.success(order);
    }

}
