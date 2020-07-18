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
import com.yx.web.goods.service.GoodsCommonService;
import com.yx.web.goods.mapper.GoodsCommonMapper;

import com.yx.web.goods.model.GoodsCommon;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("GoodsCommonService")
public class GoodsCommonServiceImpl  extends ServiceMybatis<GoodsCommon> implements GoodsCommonService {

	@Resource
	private GoodsCommonMapper GoodsCommonMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsCommon
	 * @return
	 */
	public int saveGoodsCommon(GoodsCommon GoodsCommon) {
		return this.save(GoodsCommon);
	}

	/**
	 * 删除
	* @param GoodsCommon
	* @return
	 */
	public int deleteGoodsCommon(GoodsCommon GoodsCommon) {
		return this.delete(GoodsCommon);
	}


}
