package com.yx.web.base.service.impl;

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
import com.yx.web.base.service.PaymentService;
import com.yx.web.base.mapper.PaymentMapper;

import com.yx.web.base.model.Payment;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("PaymentService")
public class PaymentServiceImpl  extends ServiceMybatis<Payment> implements PaymentService {

	@Resource
	private PaymentMapper PaymentMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Payment
	 * @return
	 */
	public int savePayment(Payment Payment) {
		return this.save(Payment);
	}

	/**
	 * 删除
	* @param Payment
	* @return
	 */
	public int deletePayment(Payment Payment) {
		return this.delete(Payment);
	}


}
