package com.yx.web.goods.service;

import com.yx.common.base.BaseService;
import com.yx.web.goods.model.GoodsSpec;

/**
 * 
 * @author
 */

public interface GoodsSpecService extends BaseService<GoodsSpec>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsSpec
	 * @return
	 */
	public int saveGoodsSpec(GoodsSpec GoodsSpec) ;
	/**
	 * 删除
	* @param GoodsSpec
	* @return
	 */
	public int deleteGoodsSpec(GoodsSpec GoodsSpec);


}
