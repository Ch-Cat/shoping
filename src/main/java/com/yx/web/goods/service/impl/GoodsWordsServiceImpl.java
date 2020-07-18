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
import com.yx.web.goods.service.GoodsWordsService;
import com.yx.web.goods.mapper.GoodsWordsMapper;

import com.yx.web.goods.model.GoodsWords;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("GoodsWordsService")
public class GoodsWordsServiceImpl  extends ServiceMybatis<GoodsWords> implements GoodsWordsService {

	@Resource
	private GoodsWordsMapper GoodsWordsMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsWords
	 * @return
	 */
	public int saveGoodsWords(GoodsWords GoodsWords) {
		return this.save(GoodsWords);
	}

	/**
	 * 删除
	* @param GoodsWords
	* @return
	 */
	public int deleteGoodsWords(GoodsWords GoodsWords) {
		return this.delete(GoodsWords);
	}


}
