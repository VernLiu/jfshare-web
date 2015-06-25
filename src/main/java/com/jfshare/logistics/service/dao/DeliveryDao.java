package com.jfshare.logistics.service.dao;

import java.util.List;

import com.jfshare.logistics.service.model.Delivery;

public interface DeliveryDao {
	
	public List<Delivery> getAll();
	
	public Delivery getDeliveryById(Long id);
	
	public Delivery updateById(Delivery entity);

	public void save(Delivery entity);
	
}
