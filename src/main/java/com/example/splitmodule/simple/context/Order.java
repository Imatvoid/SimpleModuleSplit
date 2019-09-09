package com.example.splitmodule.simple.context;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 不能更简单的订单
 */
@Data
public class Order {
    // 外部订单来源
    private String externalSource;
    // 外部订单号
    private String externalOrderNo;
    // 订单标志
    private String orderMark;
    // 订单类型
    private String orderType;
    // 订单状态
    private Integer orderStatus;

    // 店铺编号
    private String shopNo;
    // 承运商编号
    private String shipperNo;
    // 顾客姓名
    private String consigneeName;
    // 顾客电话
    private String consigneePhone;
    // 期望送达日期
    private Date expectDate;
    // 四级地址
    private String addressProvince;
    private String addressCity;
    private String addressCounty;
    private String addressTown;

    // 订单商品明细
    List<OrderDetail> orderDetailList;

}
