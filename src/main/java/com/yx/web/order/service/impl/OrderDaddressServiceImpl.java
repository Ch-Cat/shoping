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
import com.yx.web.order.service.OrderDaddressService;
import com.yx.web.order.mapper.OrderDaddressMapper;

import com.yx.web.order.model.OrderDaddress;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("OrderDaddressService")
public class OrderDaddressServiceImpl  extends ServiceMybatis<OrderDaddress> implements OrderDaddressService {

	@Resource
	private OrderDaddressMapper OrderDaddressMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderDaddress
	 * @return
	 */
	public int saveOrderDaddress(OrderDaddress OrderDaddress) {
		return this.save(OrderDaddress);
	}

	/**
	 * 删除
	* @param OrderDaddress
	* @return
	 */
	public int deleteOrderDaddress(OrderDaddress OrderDaddress) {
		return this.delete(OrderDaddress);
	}


}
