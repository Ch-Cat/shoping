package com.yx.web.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import com.yx.common.base.ServiceMybatis;
import com.yx.web.order.service.OrderPayService;
import com.yx.web.order.mapper.OrderPayMapper;

import com.yx.web.order.model.OrderPay;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("OrderPayService")
public class OrderPayServiceImpl  extends ServiceMybatis<OrderPay> implements OrderPayService {

	@Resource
	private OrderPayMapper OrderPayMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderPay
	 * @return
	 */
	public int saveOrderPay(OrderPay OrderPay) {
		return this.save(OrderPay);
	}

	/**
	 * 删除
	* @param OrderPay
	* @return
	 */
	public int deleteOrderPay(OrderPay OrderPay) {
		return this.delete(OrderPay);
	}


}
