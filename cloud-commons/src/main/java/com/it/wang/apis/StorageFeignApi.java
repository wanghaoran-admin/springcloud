package com.it.wang.apis;

import com.it.wang.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi {

    /**
     * 扣减库存
     * @param productId 商品ID
     * @param count 扣减数量
     * @return 结果集
     */
    @PostMapping("/t-storage/storage/decrease")
    Result<Object> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
