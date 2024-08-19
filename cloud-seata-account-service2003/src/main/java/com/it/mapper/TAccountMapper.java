package com.it.mapper;

import com.it.entity.TAccount;
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
public interface TAccountMapper extends BaseMapper<TAccount> {
    void decrease(@Param("userId") Long userId, @Param("money") Long money);
}
