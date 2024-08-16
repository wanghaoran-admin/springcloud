package com.it.wang.apis;

import com.it.wang.entity.dto.PayDTO;
import com.it.wang.resp.Result;
import com.it.wang.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

@Component
public class PayFeignSentinelFallback implements PayFeignSentinelApi {
    @Override
    public Result<PayDTO> getPayByOrderNo(String orderNo) {
        return Result.error(ReturnCodeEnum.RC500.getCode(), "对方服务不可用！！");
    }
}
