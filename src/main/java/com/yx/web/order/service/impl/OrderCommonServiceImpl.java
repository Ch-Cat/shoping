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
import com.yx.web.order.service.OrderCommonService;
import com.yx.web.order.mapper.OrderCommonMapper;

import com.yx.web.order.model.OrderCommon;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("OrderCommonService")
public class OrderCommonServiceImpl  extends ServiceMybatis<OrderCommon> implements OrderCommonService {

	@Resource
	private OrderCommonMapper OrderCommonMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderCommon
	 * @return
	 */
	public int saveOrderCommon(OrderCommon OrderCommon) {
		return this.save(OrderCommon);
	}

	/**
	 * 删除
	* @param OrderCommon
	* @return
	 */
	public int deleteOrderCommon(OrderCommon OrderCommon) {
		return this.delete(OrderCommon);
	}


}
