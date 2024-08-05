package com.it.wang.apis;

import com.it.wang.entity.dto.PayDTO;
import com.it.wang.resp.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("cloud-gateway")
public interface PayFeignApi {
    @PostMapping("/pay/add")
    Result<Integer> add(@RequestBody PayDTO pay);

    @DeleteMapping("/pay/delete/{id}")
    Result<Integer> delete(@PathVariable("id") Integer id);

    @PutMapping("/pay/update")
    Result<Integer> updatePay(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/getAll")
    Result<List<PayDTO>> getAll();

    @GetMapping("/pay/getById/{id}")
    Result<PayDTO> getById(@PathVariable("id") Integer id);

    @GetMapping("/pay/Test")
    Result<Integer> Test();

    @GetMapping("/pay/circuit/{id}")
    String myCircuit(@PathVariable("id") Integer id);

    @GetMapping("/pay/rateLimit/{id}")
    String myRateLimit(@PathVariable("id") Integer id);


    /**
     * 链路追踪
     * @param id
     * @return
     */
    @GetMapping("/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);





    @GetMapping("/feign/gateway/pay/get/{id}")
    Result<PayDTO> getById4Gateway(@PathVariable("id") Integer id);

    @GetMapping("/feign/gateway/pay/getInfo")
    Result<String> getInfo4Gateway();
}
