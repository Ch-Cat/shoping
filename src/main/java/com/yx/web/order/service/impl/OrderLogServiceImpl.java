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
import com.yx.web.order.service.OrderLogService;
import com.yx.web.order.mapper.OrderLogMapper;

import com.yx.web.order.model.OrderLog;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("OrderLogService")
public class OrderLogServiceImpl  extends ServiceMybatis<OrderLog> implements OrderLogService {

	@Resource
	private OrderLogMapper OrderLogMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderLog
	 * @return
	 */
	public int saveOrderLog(OrderLog OrderLog) {
		return this.save(OrderLog);
	}

	/**
	 * 删除
	* @param OrderLog
	* @return
	 */
	public int deleteOrderLog(OrderLog OrderLog) {
		return this.delete(OrderLog);
	}


}
