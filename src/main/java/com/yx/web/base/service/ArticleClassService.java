package com.yx.web.base.service;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.ArticleClass;

/**
 * 
 * @author
 */

public interface ArticleClassService extends BaseService<ArticleClass>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param ArticleClass
	 * @return
	 */
	public int saveArticleClass(ArticleClass ArticleClass) ;
	/**
	 * 删除
	* @param ArticleClass
	* @return
	 */
	public int deleteArticleClass(ArticleClass ArticleClass);


}
