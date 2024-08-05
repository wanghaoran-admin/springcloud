package com.it.wang.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 支付交易表
 * </p>
 *
 * @author author
 * @since 2024-07-11
 */
@Data
@Schema(title = "支付交易表实体")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_pay")
public class TPay implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(title = "支付id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * 支付流水号
     */
    @Schema(title = "支付流水号")
    @TableField("pay_no")
    private String payNo;


    /**
     * 订单流水号
     */
    @Schema(title = "订单流水号")
    private String orderNo;


    /**
     * 用户账号ID
     */
    @Schema(title = "用户账号ID")
    private Integer userId;


    /**
     * 交易金额
     */
    @Schema(title = "交易金额")
    private BigDecimal amount;


    /**
     * 删除标志, 默认0不删除,1删除
     */
    @Schema(title = "删除标志")
    @TableLogic
    private Integer deleted;


    /**
     * 创建时间
     */
    @Schema(title = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;



    /**
     * 更新时间
     */
    @Schema(title = "更新时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
