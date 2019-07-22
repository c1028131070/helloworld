package com.goods.search.api.DTO;

import java.io.Serializable;

public class HistoryPriceRequestDTO implements Serializable {

	String productId;

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
}
