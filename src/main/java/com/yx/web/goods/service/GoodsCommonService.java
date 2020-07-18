package com.yx.web.goods.service;

import com.yx.common.base.BaseService;
import com.yx.web.goods.model.GoodsCommon;

/**
 * 
 * @author
 */

public interface GoodsCommonService extends BaseService<GoodsCommon>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsCommon
	 * @return
	 */
	public int saveGoodsCommon(GoodsCommon GoodsCommon) ;
	/**
	 * 删除
	* @param GoodsCommon
	* @return
	 */
	public int deleteGoodsCommon(GoodsCommon GoodsCommon);


}
