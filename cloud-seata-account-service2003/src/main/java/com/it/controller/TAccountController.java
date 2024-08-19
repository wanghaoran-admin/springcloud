package com.it.controller;


import com.it.service.ITAccountService;
import com.it.wang.resp.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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
@Slf4j
@RequestMapping("/t-account")
public class TAccountController {
    @Resource
    private ITAccountService accountService;

    @PostMapping("/account/decrease")
    Result<Object> decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money) {
        accountService.decrease(userId, money);
        return Result.success("扣减余额成功");
    }
}
