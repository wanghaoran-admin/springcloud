package com.it.service.impl;

import com.it.entity.TStorage;
import com.it.mapper.TStorageMapper;
import com.it.service.ITStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class TStorageServiceImpl extends ServiceImpl<TStorageMapper, TStorage> implements ITStorageService {
    @Resource
    private TStorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------------->StorageService 开始扣减库存");
        storageMapper.decrease(productId, count);
        log.info("------------->StorageService 扣减库存结束");
    }
}
