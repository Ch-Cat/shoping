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
import com.yx.web.goods.service.GoodsClassTagService;
import com.yx.web.goods.mapper.GoodsClassTagMapper;

import com.yx.web.goods.model.GoodsClassTag;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("GoodsClassTagService")
public class GoodsClassTagServiceImpl  extends ServiceMybatis<GoodsClassTag> implements GoodsClassTagService {

	@Resource
	private GoodsClassTagMapper GoodsClassTagMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsClassTag
	 * @return
	 */
	public int saveGoodsClassTag(GoodsClassTag GoodsClassTag) {
		return this.save(GoodsClassTag);
	}

	/**
	 * 删除
	* @param GoodsClassTag
	* @return
	 */
	public int deleteGoodsClassTag(GoodsClassTag GoodsClassTag) {
		return this.delete(GoodsClassTag);
	}


}
