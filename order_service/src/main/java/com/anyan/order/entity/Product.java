package com.anyan.order.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品实体类
 */
@Data
public class Product {
	private Long id;
	private String productName;
	private Integer status;
	private BigDecimal price;
	private String productDesc;
	private String caption;
	private Integer inventory;
}
