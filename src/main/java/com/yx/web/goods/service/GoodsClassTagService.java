package com.yx.web.goods.service;

import com.yx.common.base.BaseService;
import com.yx.web.goods.model.GoodsClassTag;

/**
 * 
 * @author
 */

public interface GoodsClassTagService extends BaseService<GoodsClassTag>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsClassTag
	 * @return
	 */
	public int saveGoodsClassTag(GoodsClassTag GoodsClassTag) ;
	/**
	 * 删除
	* @param GoodsClassTag
	* @return
	 */
	public int deleteGoodsClassTag(GoodsClassTag GoodsClassTag);


}
