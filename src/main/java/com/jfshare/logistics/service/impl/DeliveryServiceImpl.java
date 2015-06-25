package com.jfshare.logistics.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jfshare.logistics.service.DeliveryService;
import com.jfshare.logistics.service.dao.DeliveryDao;
import com.jfshare.logistics.service.model.Delivery;

@Transactional(readOnly=true)
public class DeliveryServiceImpl implements DeliveryService {

	private DeliveryDao deliveryDao; 
	
	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}
	
	public List<Delivery> getAllDeliverys() {
		return deliveryDao.getAll();
	}
	
	public Delivery getDelivery(Long id) {
		return deliveryDao.getDeliveryById(id);
	}
	
	public void add(Long orderId, Date latestTime, String latestStatus, String detail, String remark) {
		Delivery delivery = new Delivery();
		delivery.setOrderId(orderId != null ? Long.valueOf(orderId) : null);
		delivery.setDetail(detail);
		delivery.setRemark(remark);
		delivery.setOrderType(OrderType.OverSeas.getValue());
		save(delivery);
	}

	@Transactional(readOnly=false)
	public void update(Long id, Long orderId, String detail, String remark) {
		Delivery delivery = new Delivery();
		delivery.setId(id);
		delivery.setOrderId(orderId != null ? Long.valueOf(orderId) : null);
		delivery.setDetail(detail);
		delivery.setRemark(remark);
		deliveryDao.updateById(delivery);
	}
	
	@Transactional(readOnly=false)
	public void save(Delivery delivery) {
		deliveryDao.save(delivery);
	}
}
