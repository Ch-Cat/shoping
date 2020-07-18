package com.yx.web.blog.service.impl;

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
import com.yx.web.blog.service.BlogTemplateService;
import com.yx.web.blog.mapper.BlogTemplateMapper;

import com.yx.web.blog.model.BlogTemplate;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("BlogTemplateService")
public class BlogTemplateServiceImpl  extends ServiceMybatis<BlogTemplate> implements BlogTemplateService {

	@Resource
	private BlogTemplateMapper BlogTemplateMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param BlogTemplate
	 * @return
	 */
	public int saveBlogTemplate(BlogTemplate BlogTemplate) {
		return this.save(BlogTemplate);
	}

	/**
	 * 删除
	* @param BlogTemplate
	* @return
	 */
	public int deleteBlogTemplate(BlogTemplate BlogTemplate) {
		return this.delete(BlogTemplate);
	}


}
