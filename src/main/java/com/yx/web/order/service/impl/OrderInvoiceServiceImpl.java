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
import com.yx.web.order.service.OrderInvoiceService;
import com.yx.web.order.mapper.OrderInvoiceMapper;

import com.yx.web.order.model.OrderInvoice;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("OrderInvoiceService")
public class OrderInvoiceServiceImpl  extends ServiceMybatis<OrderInvoice> implements OrderInvoiceService {

	@Resource
	private OrderInvoiceMapper OrderInvoiceMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderInvoice
	 * @return
	 */
	public int saveOrderInvoice(OrderInvoice OrderInvoice) {
		return this.save(OrderInvoice);
	}

	/**
	 * 删除
	* @param OrderInvoice
	* @return
	 */
	public int deleteOrderInvoice(OrderInvoice OrderInvoice) {
		return this.delete(OrderInvoice);
	}


}
