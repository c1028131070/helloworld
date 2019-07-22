package com.goods.display.api.DTO;

import java.io.Serializable;

public class ModuleInfoDTO implements Serializable{

	private String moduleName;
	private String moduleIp;
	private String modulePort;
	private Integer moduleLatency;
	private String occupiedRateOfBandwidth;
	private String occupiedRateOfMemory;
	private String occupiedRateOfCpu;
	private Boolean moduleCondition = false;

	/**
	 * 获取moduleName
	 *
	 * @return moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * 设置moduleName
	 *
	 * @param moduleName moduleName
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * 获取moduleIp
	 *
	 * @return moduleIp
	 */
	public String getModuleIp() {
		return moduleIp;
	}

	/**
	 * 设置moduleIp
	 *
	 * @param moduleIp moduleIp
	 */
	public void setModuleIp(String moduleIp) {
		this.moduleIp = moduleIp;
	}

	/**
	 * 获取modulePort
	 *
	 * @return modulePort
	 */
	public String getModulePort() {
		return modulePort;
	}

	/**
	 * 设置modulePort
	 *
	 * @param modulePort modulePort
	 */
	public void setModulePort(String modulePort) {
		this.modulePort = modulePort;
	}

	/**
	 * 获取moduleLatency
	 *
	 * @return moduleLatency
	 */
	public Integer getModuleLatency() {
		return moduleLatency;
	}

	/**
	 * 设置moduleLatency
	 *
	 * @param moduleLatency moduleLatency
	 */
	public void setModuleLatency(Integer moduleLatency) {
		this.moduleLatency = moduleLatency;
	}

	/**
	 * 获取occupiedRateOfBandwidth
	 *
	 * @return occupiedRateOfBandwidth
	 */
	public String getOccupiedRateOfBandwidth() {
		return occupiedRateOfBandwidth;
	}

	/**
	 * 设置occupiedRateOfBandwidth
	 *
	 * @param occupiedRateOfBandwidth occupiedRateOfBandwidth
	 */
	public void setOccupiedRateOfBandwidth(String occupiedRateOfBandwidth) {
		this.occupiedRateOfBandwidth = occupiedRateOfBandwidth;
	}

	/**
	 * 获取occupiedRateOfMemory
	 *
	 * @return occupiedRateOfMemory
	 */
	public String getOccupiedRateOfMemory() {
		return occupiedRateOfMemory;
	}

	/**
	 * 设置occupiedRateOfMemory
	 *
	 * @param occupiedRateOfMemory occupiedRateOfMemory
	 */
	public void setOccupiedRateOfMemory(String occupiedRateOfMemory) {
		this.occupiedRateOfMemory = occupiedRateOfMemory;
	}

	/**
	 * 获取occupiedRateOfCpu
	 *
	 * @return occupiedRateOfCpu
	 */
	public String getOccupiedRateOfCpu() {
		return occupiedRateOfCpu;
	}

	/**
	 * 设置occupiedRateOfCpu
	 *
	 * @param occupiedRateOfCpu occupiedRateOfCpu
	 */
	public void setOccupiedRateOfCpu(String occupiedRateOfCpu) {
		this.occupiedRateOfCpu = occupiedRateOfCpu;
	}

	/**
	 * 获取moduleCondition
	 *
	 * @return moduleCondition
	 */
	public Boolean getModuleCondition() {
		return moduleCondition;
	}

	/**
	 * 设置moduleCondition
	 *
	 * @param moduleCondition moduleCondition
	 */
	public void setModuleCondition(Boolean moduleCondition) {
		this.moduleCondition = moduleCondition;
	}
}
