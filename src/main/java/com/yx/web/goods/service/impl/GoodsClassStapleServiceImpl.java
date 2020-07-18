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
import com.yx.web.goods.service.GoodsClassStapleService;
import com.yx.web.goods.mapper.GoodsClassStapleMapper;

import com.yx.web.goods.model.GoodsClassStaple;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("GoodsClassStapleService")
public class GoodsClassStapleServiceImpl  extends ServiceMybatis<GoodsClassStaple> implements GoodsClassStapleService {

	@Resource
	private GoodsClassStapleMapper GoodsClassStapleMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsClassStaple
	 * @return
	 */
	public int saveGoodsClassStaple(GoodsClassStaple GoodsClassStaple) {
		return this.save(GoodsClassStaple);
	}

	/**
	 * 删除
	* @param GoodsClassStaple
	* @return
	 */
	public int deleteGoodsClassStaple(GoodsClassStaple GoodsClassStaple) {
		return this.delete(GoodsClassStaple);
	}


}
