package com.yx.web.base.service;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.Article;

/**
 * 
 * @author
 */

public interface ArticleService extends BaseService<Article>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Article
	 * @return
	 */
	public int saveArticle(Article Article) ;
	/**
	 * 删除
	* @param Article
	* @return
	 */
	public int deleteArticle(Article Article);


}
