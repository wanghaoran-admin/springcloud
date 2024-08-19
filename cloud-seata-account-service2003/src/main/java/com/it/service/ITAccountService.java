package com.it.service;

import com.it.entity.TAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-08-18
 */
public interface ITAccountService extends IService<TAccount> {
    void decrease(Long userId, Long money);
}
