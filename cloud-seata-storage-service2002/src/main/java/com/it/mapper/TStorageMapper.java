package com.it.mapper;

import com.it.entity.TStorage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-08-18
 */
public interface TStorageMapper extends BaseMapper<TStorage> {
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
