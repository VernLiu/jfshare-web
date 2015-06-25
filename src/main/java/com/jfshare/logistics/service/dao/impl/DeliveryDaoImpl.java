package com.jfshare.logistics.service.dao.impl;

import java.util.HashMap;
import java.util.List;

import com.jfshare.jdbc.dao.GenericDao;
import com.jfshare.logistics.service.dao.DeliveryDao;
import com.jfshare.logistics.service.model.Delivery;

public class DeliveryDaoImpl extends GenericDao<Delivery> implements DeliveryDao {
	
	public DeliveryDaoImpl() {
		setEntityClass(Delivery.class);
	}
	
	private static final String GET_ALL_SQL = new StringBuilder()
		.append(" select id,                       ")
		.append(" order_id orderId,                ")
		.append(" delivery_id deliveryId,          ")
		.append(" order_type orderType,            ")
		.append(" product_name productName,        ")
		.append(" remark,                          ")
		.append(" delivery_company deliveryCompany ")
		.append(" from jfs_lgsts_delivery          ").toString();
	
	public List<Delivery> getAll() {
	    return super.getAll(GET_ALL_SQL, new HashMap<String, Object>(0));
	}
	
	
	
	private static final String GET_DELIVERY_BY_ID_SQL = new StringBuilder()
		.append(" select id,                       ")
		.append(" order_id orderId,                ")
		.append(" delivery_id deliveryId,          ")
		.append(" order_type orderType,            ")
		.append(" product_name productName,        ")
		.append(" remark,                          ")
		.append(" delivery_company deliveryCompany ")
		.append(" from jfs_lgsts_delivery          ")
		.append(" where id = :id                   ").toString();
	
	public Delivery getDeliveryById(Long id) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
	    return super.get(GET_DELIVERY_BY_ID_SQL, params);
	}
	
	
	
	
	private static final String update_BY_ID_SQL = new StringBuilder()
		.append(" update jfs_lgsts_delivery(       ")
		.append(" detail,                          ")
		.append(" remark                           ")
		.append(" ) set (                          ")
		.append(" :detail,                         ")
		.append(" :remark )                        ")
		.append(" where id = :id                   ").toString();
	
	public Delivery updateById(Delivery entity) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", entity.getId());
		params.put("detail", entity.getDetail());
		params.put("remark", entity.getRemark());
	    return super.get(update_BY_ID_SQL, params);
	}
	

	
	private static final String SAVE_SQL = new StringBuilder()
		.append(" insert into jfs_lgsts_delivery( ")
		.append(" id,                             ")
		.append(" order_id,                       ")
		.append(" delivery_id,                    ")
		.append(" order_type,                     ")
		.append(" product_name,                   ")
		.append(" remark,                         ")
		.append(" delivery_company                ")
		.append(" ) value (                       ")
		.append(" :id,                            ")
		.append(" :orderId,                       ")
		.append(" :deliveryId,                    ")
		.append(" :orderType,                     ")
		.append(" :productName,                   ")
		.append(" :remark,                        ")
		.append(" :deliveryCompany)               ").toString();
	
	public void save(Delivery entity) {
		super.save(SAVE_SQL, entity);
	}
}
