package com.yx.web.goods.service;

import com.yx.common.base.BaseService;
import com.yx.web.goods.model.GoodsClassStaple;

/**
 * 
 * @author
 */

public interface GoodsClassStapleService extends BaseService<GoodsClassStaple>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsClassStaple
	 * @return
	 */
	public int saveGoodsClassStaple(GoodsClassStaple GoodsClassStaple) ;
	/**
	 * 删除
	* @param GoodsClassStaple
	* @return
	 */
	public int deleteGoodsClassStaple(GoodsClassStaple GoodsClassStaple);


}
