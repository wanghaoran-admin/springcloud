package com.it.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.entity.TOrder;
import com.it.mapper.TOrderMapper;
import com.it.service.ITOrderService;
import com.it.wang.apis.AccountFeignApi;
import com.it.wang.apis.StorageFeignApi;
import io.seata.core.context.RootContext;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-08-18
 */
@Service
@Slf4j
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

    @Resource
    private TOrderMapper orderMapper;
    @Resource
    private StorageFeignApi storageFeignApi;
    @Resource
    private AccountFeignApi accountFeignApi;

    @Override
    public void create(TOrder order) {
        // xid全局事务检查
        String xid = RootContext.getXID();

        // 1. 新建订单
        log.info("-------------> 开始新建订单, XID: {}", xid);
        order.setStatus(0);
        int result = orderMapper.insert(order);

        TOrder orderFromDB;
        if (result > 0) {

            System.out.println(order.getId());
            orderFromDB = orderMapper.selectById(order.getId());
            log.info("-------------> 新建订单成功, OrderInfo: {}", orderFromDB);

            // 2. 扣减库存
            log.info("-------------> 开始扣减库存");
            storageFeignApi.decrease(orderFromDB.getProductId(), orderFromDB.getCount());
            log.info("-------------> 扣减库存成功");

            // 3. 扣减账户余额
            log.info("-------------> 开始扣减余额");
            accountFeignApi.decrease(order.getUserId(), Long.valueOf(order.getMoeny()));
            log.info("-------------> 扣余额存成功");

            // 4. 修改订单状态
            log.info("-------------> 开始修改订单状态");
            order.setId(orderFromDB.getId());
            order.setStatus(1);
            int i = orderMapper.updateById(order);
            log.info("-------------> 修改订单状态成功");

        }
        log.info("-------------> 结束新建订单, XID: {}", xid);
    }
}
