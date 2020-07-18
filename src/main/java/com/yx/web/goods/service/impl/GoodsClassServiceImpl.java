package com.yx.web.goods.service.impl;

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
import com.yx.web.goods.service.GoodsClassService;
import com.yx.web.goods.mapper.GoodsClassMapper;

import com.yx.web.goods.model.GoodsClass;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("GoodsClassService")
public class GoodsClassServiceImpl  extends ServiceMybatis<GoodsClass> implements GoodsClassService {

	@Resource
	private GoodsClassMapper GoodsClassMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsClass
	 * @return
	 */
	public int saveGoodsClass(GoodsClass GoodsClass) {
		return this.save(GoodsClass);
	}

	/**
	 * 删除
	* @param GoodsClass
	* @return
	 */
	public int deleteGoodsClass(GoodsClass GoodsClass) {
		return this.delete(GoodsClass);
	}


}
