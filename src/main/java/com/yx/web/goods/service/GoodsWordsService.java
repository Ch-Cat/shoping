package com.yx.web.goods.service;

import com.yx.common.base.BaseService;
import com.yx.web.goods.model.GoodsWords;

/**
 * 
 * @author
 */

public interface GoodsWordsService extends BaseService<GoodsWords>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsWords
	 * @return
	 */
	public int saveGoodsWords(GoodsWords GoodsWords) ;
	/**
	 * 删除
	* @param GoodsWords
	* @return
	 */
	public int deleteGoodsWords(GoodsWords GoodsWords);


}
