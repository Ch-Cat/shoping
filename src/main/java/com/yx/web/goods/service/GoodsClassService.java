package com.yx.web.goods.service;

import com.yx.common.base.BaseService;
import com.yx.web.goods.model.GoodsClass;

/**
 * 
 * @author
 */

public interface GoodsClassService extends BaseService<GoodsClass>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsClass
	 * @return
	 */
	public int saveGoodsClass(GoodsClass GoodsClass) ;
	/**
	 * 删除
	* @param GoodsClass
	* @return
	 */
	public int deleteGoodsClass(GoodsClass GoodsClass);


}
