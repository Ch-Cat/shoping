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
import com.yx.web.base.service.ArticleService;
import com.yx.web.base.mapper.ArticleMapper;

import com.yx.web.base.model.Article;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("ArticleService")
public class ArticleServiceImpl  extends ServiceMybatis<Article> implements ArticleService {

	@Resource
	private ArticleMapper ArticleMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Article
	 * @return
	 */
	public int saveArticle(Article Article) {
		return this.save(Article);
	}

	/**
	 * 删除
	* @param Article
	* @return
	 */
	public int deleteArticle(Article Article) {
		return this.delete(Article);
	}


}
