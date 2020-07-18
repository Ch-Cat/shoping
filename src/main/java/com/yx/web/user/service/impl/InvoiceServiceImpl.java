package com.yx.web.user.service.impl;

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
import com.yx.web.user.service.InvoiceService;
import com.yx.web.user.mapper.InvoiceMapper;

import com.yx.web.user.model.Invoice;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("InvoiceService")
public class InvoiceServiceImpl  extends ServiceMybatis<Invoice> implements InvoiceService {

	@Resource
	private InvoiceMapper InvoiceMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Invoice
	 * @return
	 */
	public int saveInvoice(Invoice Invoice) {
		return this.save(Invoice);
	}

	/**
	 * 删除
	* @param Invoice
	* @return
	 */
	public int deleteInvoice(Invoice Invoice) {
		return this.delete(Invoice);
	}


}
