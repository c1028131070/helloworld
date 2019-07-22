package com.goods.search.entity;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private String productId;
	private String productName;
	private String price;
	private String categoryId;
	private String categoryName;
	private String sellCount;
	private String reviewCount;
	private String collectCount;
	private Integer stock;
	private String deliveryAdd;
	private String shopId;
	private String shopName;
	private String productImg;
	private Double shopdsrMs;
	private Double shopdsrFw;
	private Double shopdsrWl;
	private String productSku;
	private String productUrl;
	private String productDetail;
	private Double productScore;
	private String recommendedReason;
	private String updateTime;
	private String spareField1;
	private String spareField2;
	private String spareField3;

	/**
	 * 获取id
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置id
	 *
	 * @param id id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取productId
	 *
	 * @return productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * 设置productId
	 *
	 * @param productId productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * 获取productName
	 *
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 设置productName
	 *
	 * @param productName productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 获取price
	 *
	 * @return price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * 设置price
	 *
	 * @param price price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * 获取categoryId
	 *
	 * @return categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * 设置categoryId
	 *
	 * @param categoryId categoryId
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 获取categoryName
	 *
	 * @return categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * 设置categoryName
	 *
	 * @param categoryName categoryName
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * 获取sellCount
	 *
	 * @return sellCount
	 */
	public String getSellCount() {
		return sellCount;
	}

	/**
	 * 设置sellCount
	 *
	 * @param sellCount sellCount
	 */
	public void setSellCount(String sellCount) {
		this.sellCount = sellCount;
	}

	/**
	 * 获取reviewCount
	 *
	 * @return reviewCount
	 */
	public String getReviewCount() {
		return reviewCount;
	}

	/**
	 * 设置reviewCount
	 *
	 * @param reviewCount reviewCount
	 */
	public void setReviewCount(String reviewCount) {
		this.reviewCount = reviewCount;
	}

	/**
	 * 获取collectCount
	 *
	 * @return collectCount
	 */
	public String getCollectCount() {
		return collectCount;
	}

	/**
	 * 设置collectCount
	 *
	 * @param collectCount collectCount
	 */
	public void setCollectCount(String collectCount) {
		this.collectCount = collectCount;
	}

	/**
	 * 获取stock
	 *
	 * @return stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * 设置stock
	 *
	 * @param stock stock
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * 获取deliveryAdd
	 *
	 * @return deliveryAdd
	 */
	public String getDeliveryAdd() {
		return deliveryAdd;
	}

	/**
	 * 设置deliveryAdd
	 *
	 * @param deliveryAdd deliveryAdd
	 */
	public void setDeliveryAdd(String deliveryAdd) {
		this.deliveryAdd = deliveryAdd;
	}

	/**
	 * 获取shopId
	 *
	 * @return shopId
	 */
	public String getShopId() {
		return shopId;
	}

	/**
	 * 设置shopId
	 *
	 * @param shopId shopId
	 */
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	/**
	 * 获取shopName
	 *
	 * @return shopName
	 */
	public String getShopName() {
		return shopName;
	}

	/**
	 * 设置shopName
	 *
	 * @param shopName shopName
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	/**
	 * 获取productImg
	 *
	 * @return productImg
	 */
	public String getProductImg() {
		return productImg;
	}

	/**
	 * 设置productImg
	 *
	 * @param productImg productImg
	 */
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	/**
	 * 获取shopdsrMs
	 *
	 * @return shopdsrMs
	 */
	public Double getShopdsrMs() {
		return shopdsrMs;
	}

	/**
	 * 设置shopdsrMs
	 *
	 * @param shopdsrMs shopdsrMs
	 */
	public void setShopdsrMs(Double shopdsrMs) {
		this.shopdsrMs = shopdsrMs;
	}

	/**
	 * 获取shopdsrFw
	 *
	 * @return shopdsrFw
	 */
	public Double getShopdsrFw() {
		return shopdsrFw;
	}

	/**
	 * 设置shopdsrFw
	 *
	 * @param shopdsrFw shopdsrFw
	 */
	public void setShopdsrFw(Double shopdsrFw) {
		this.shopdsrFw = shopdsrFw;
	}

	/**
	 * 获取shopdsrWl
	 *
	 * @return shopdsrWl
	 */
	public Double getShopdsrWl() {
		return shopdsrWl;
	}

	/**
	 * 设置shopdsrWl
	 *
	 * @param shopdsrWl shopdsrWl
	 */
	public void setShopdsrWl(Double shopdsrWl) {
		this.shopdsrWl = shopdsrWl;
	}

	/**
	 * 获取productSku
	 *
	 * @return productSku
	 */
	public String getProductSku() {
		return productSku;
	}

	/**
	 * 设置productSku
	 *
	 * @param productSku productSku
	 */
	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}

	/**
	 * 获取productUrl
	 *
	 * @return productUrl
	 */
	public String getProductUrl() {
		return productUrl;
	}

	/**
	 * 设置productUrl
	 *
	 * @param productUrl productUrl
	 */
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	/**
	 * 获取productDetail
	 *
	 * @return productDetail
	 */
	public String getProductDetail() {
		return productDetail;
	}

	/**
	 * 设置productDetail
	 *
	 * @param productDetail productDetail
	 */
	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	/**
	 * 获取productScore
	 *
	 * @return productScore
	 */
	public Double getProductScore() {
		return productScore;
	}

	/**
	 * 设置productScore
	 *
	 * @param productScore productScore
	 */
	public void setProductScore(Double productScore) {
		this.productScore = productScore;
	}

	/**
	 * 获取recommendedReason
	 *
	 * @return recommendedReason
	 */
	public String getRecommendedReason() {
		return recommendedReason;
	}

	/**
	 * 设置recommendedReason
	 *
	 * @param recommendedReason recommendedReason
	 */
	public void setRecommendedReason(String recommendedReason) {
		this.recommendedReason = recommendedReason;
	}

	/**
	 * 获取updateTime
	 *
	 * @return updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置updateTime
	 *
	 * @param updateTime updateTime
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取spareField1
	 *
	 * @return spareField1
	 */
	public String getSpareField1() {
		return spareField1;
	}

	/**
	 * 设置spareField1
	 *
	 * @param spareField1 spareField1
	 */
	public void setSpareField1(String spareField1) {
		this.spareField1 = spareField1;
	}

	/**
	 * 获取spareField2
	 *
	 * @return spareField2
	 */
	public String getSpareField2() {
		return spareField2;
	}

	/**
	 * 设置spareField2
	 *
	 * @param spareField2 spareField2
	 */
	public void setSpareField2(String spareField2) {
		this.spareField2 = spareField2;
	}

	/**
	 * 获取spareField3
	 *
	 * @return spareField3
	 */
	public String getSpareField3() {
		return spareField3;
	}

	/**
	 * 设置spareField3
	 *
	 * @param spareField3 spareField3
	 */
	public void setSpareField3(String spareField3) {
		this.spareField3 = spareField3;
	}

	@Override
	public String toString() {
		return org.apache.commons.lang3.builder.ReflectionToStringBuilder.toString(this);
	}
}
