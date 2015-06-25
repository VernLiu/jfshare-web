package com.jfshare.logistics.service.model;

import java.io.Serializable;
import java.util.Date;

public class Delivery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4953353872730432657L;
	private Long id;
	private Long orderId;
	private String deliveryId;
	private Integer orderType;
	private String productName;
	private String remark;
	private String deliveryCompany;
	private Date latestTime;
	private String latestStatus;
	private String latestProcessor;
	private String Detail;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public String getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getDeliveryCompany() {
		return deliveryCompany;
	}
	public void setDeliveryCompany(String deliveryCompany) {
		this.deliveryCompany = deliveryCompany;
	}
	
	public Date getLatestTime() {
		return latestTime;
	}
	public void setLatestTime(Date latestTime) {
		this.latestTime = latestTime;
	}
	
	public String getLatestStatus() {
		return latestStatus;
	}
	public void setLatestStatus(String latestStatus) {
		this.latestStatus = latestStatus;
	}
	
	public String getLatestProcessor() {
		return latestProcessor;
	}
	public void setLatestProcessor(String latestProcessor) {
		this.latestProcessor = latestProcessor;
	}
	
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	
	
}
