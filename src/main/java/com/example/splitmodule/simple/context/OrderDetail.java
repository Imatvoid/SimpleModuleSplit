package com.example.splitmodule.simple.context;


import lombok.Data;

import java.math.BigDecimal;

/**
 * 不能更简单的明细
 */
@Data
public class OrderDetail {
    // 商品编码
    private String goodsNo;
    // 价格
    private Double price;
    // 数量
    private Integer quantity;
    // 商品等级
    private String goodsLevel;
    // 批次属性(生产日期等)
    private String batchNo;

}
