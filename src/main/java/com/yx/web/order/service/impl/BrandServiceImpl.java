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
import com.yx.web.order.service.BrandService;
import com.yx.web.order.mapper.BrandMapper;

import com.yx.web.order.model.Brand;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("BrandService")
public class BrandServiceImpl  extends ServiceMybatis<Brand> implements BrandService {

	@Resource
	private BrandMapper BrandMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Brand
	 * @return
	 */
	public int saveBrand(Brand Brand) {
		return this.save(Brand);
	}

	/**
	 * 删除
	* @param Brand
	* @return
	 */
	public int deleteBrand(Brand Brand) {
		return this.delete(Brand);
	}


}
