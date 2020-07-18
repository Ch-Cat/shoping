package com.yx.web.blog.service;

import com.yx.common.base.BaseService;
import com.yx.web.blog.model.BlogTemplate;

/**
 * 
 * @author
 */

public interface BlogTemplateService extends BaseService<BlogTemplate>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param BlogTemplate
	 * @return
	 */
	public int saveBlogTemplate(BlogTemplate BlogTemplate) ;
	/**
	 * 删除
	* @param BlogTemplate
	* @return
	 */
	public int deleteBlogTemplate(BlogTemplate BlogTemplate);


}
