package com.goods.display.api.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HistoryPriceResponseDTO implements Serializable {

	private List<Date> dateList;

	private List<String> dateListString;

	private List<Double> priceList;

	private Double lowestPrice;


	/**
	 * 获取dateList
	 *
	 * @return dateList
	 */
	public List<Date> getDateList() {
		return dateList;
	}

	/**
	 * 设置dateList
	 *
	 * @param dateList dateList
	 */
	public void setDateList(List<Date> dateList) {
		this.dateList = dateList;
	}

	/**
	 * 获取priceList
	 *
	 * @return priceList
	 */
	public List<Double> getPriceList() {
		return priceList;
	}

	/**
	 * 设置priceList
	 *
	 * @param priceList priceList
	 */
	public void setPriceList(List<Double> priceList) {
		this.priceList = priceList;
	}

	/**
	 * 获取dateListString
	 *
	 * @return dateListString
	 */
	public List<String> getDateListString() {
		return dateListString;
	}

	/**
	 * 设置dateListString
	 *
	 * @param dateListString dateListString
	 */
	public void setDateListString(List<String> dateListString) {
		this.dateListString = dateListString;
	}

	/**
	 * 获取lowestPrice
	 *
	 * @return lowestPrice
	 */
	public Double getLowestPrice() {
		return lowestPrice;
	}

	/**
	 * 设置lowestPrice
	 *
	 * @param lowestPrice lowestPrice
	 */
	public void setLowestPrice(Double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
}
