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
import com.yx.web.base.service.ArticleClassService;
import com.yx.web.base.mapper.ArticleClassMapper;

import com.yx.web.base.model.ArticleClass;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("ArticleClassService")
public class ArticleClassServiceImpl  extends ServiceMybatis<ArticleClass> implements ArticleClassService {

	@Resource
	private ArticleClassMapper ArticleClassMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param ArticleClass
	 * @return
	 */
	public int saveArticleClass(ArticleClass ArticleClass) {
		return this.save(ArticleClass);
	}

	/**
	 * 删除
	* @param ArticleClass
	* @return
	 */
	public int deleteArticleClass(ArticleClass ArticleClass) {
		return this.delete(ArticleClass);
	}


}
