package com.it.service;

import com.it.entity.TStorage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-08-18
 */
public interface ITStorageService extends IService<TStorage> {
    //减少库存
    void decrease(Long productId, Integer count);
}
