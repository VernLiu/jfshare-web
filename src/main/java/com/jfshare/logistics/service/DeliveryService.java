package com.jfshare.logistics.service;

import java.util.List;

import com.jfshare.logistics.service.model.Delivery;

public interface DeliveryService {

	public enum OrderType {
		Native(1), OverSeas(2);
		
		private Integer value;
		private OrderType(Integer value) {
			this.value = value;
		}
		
		public Integer getValue() {
			return value;
		}
	}

	public List<Delivery> getAllDeliverys();

	public Delivery getDelivery(Long id);
	
	public void update(Long id, Long orderId, String detail, String remark);
	
	public void save(Delivery delivery);
	
}
