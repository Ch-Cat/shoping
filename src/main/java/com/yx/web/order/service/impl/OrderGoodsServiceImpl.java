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
import com.yx.web.order.service.OrderGoodsService;
import com.yx.web.order.mapper.OrderGoodsMapper;

import com.yx.web.order.model.OrderGoods;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("OrderGoodsService")
public class OrderGoodsServiceImpl  extends ServiceMybatis<OrderGoods> implements OrderGoodsService {

	@Resource
	private OrderGoodsMapper OrderGoodsMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderGoods
	 * @return
	 */
	public int saveOrderGoods(OrderGoods OrderGoods) {
		return this.save(OrderGoods);
	}

	/**
	 * 删除
	* @param OrderGoods
	* @return
	 */
	public int deleteOrderGoods(OrderGoods OrderGoods) {
		return this.delete(OrderGoods);
	}


}
