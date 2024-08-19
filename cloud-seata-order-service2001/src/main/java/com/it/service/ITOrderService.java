package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.entity.TOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-08-18
 */
public interface ITOrderService extends IService<TOrder> {
    void create(TOrder order);
}
