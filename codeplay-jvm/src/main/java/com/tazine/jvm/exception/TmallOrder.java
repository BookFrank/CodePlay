package com.tazine.jvm.exception;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 模拟天猫订单对象
 *
 * @author frank
 * @date 2019/01/22
 */
@Data
@Builder
public class TmallOrder {

    private Long userId;

    private Long sellerId;

    private Long productId;

    private String userName;

    private String sellerName;

    private String prodName;

    private Integer num;

    private Integer payType;

    private Integer postType;

    private Integer total;

    private BigDecimal bd1;

    private BigDecimal bd2;

    private BigDecimal bd3;

    private BigDecimal bd4;

    private BigDecimal bd5;

    private BigDecimal bd6;

    private BigDecimal bd7;

    private BigDecimal bd8;

    private BigDecimal bd9;

    private BigDecimal bd10;

    private BigDecimal bd11;

    private BigDecimal bd12;

    private BigDecimal bd13;

    private BigDecimal bd14;

    private BigDecimal bd15;

    private BigDecimal bd16;
}
