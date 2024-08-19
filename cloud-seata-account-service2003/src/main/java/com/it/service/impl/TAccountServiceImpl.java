package com.it.service.impl;

import com.it.entity.TAccount;
import com.it.mapper.TAccountMapper;
import com.it.service.ITAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-18
 */
@Slf4j
@Service
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements ITAccountService {

    @Resource
    private TAccountMapper accountMapper;

    @Override
    public void decrease(Long userId, Long money) {
        log.info("------------->AccountService 开始扣减余额");
        accountMapper.decrease(userId, money);
        log.info("------------->AccountService 开始扣减余额");


        // 超时异常
         timeout();
        // 抛出异常
//         int i = 10 / 0;
    }

    private void timeout() {
        try {
            TimeUnit.SECONDS.sleep(65);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
