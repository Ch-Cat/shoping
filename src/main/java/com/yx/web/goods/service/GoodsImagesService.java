package com.yx.web.goods.service;

import com.yx.common.base.BaseService;
import com.yx.web.goods.model.GoodsImages;

/**
 * 
 * @author
 */

public interface GoodsImagesService extends BaseService<GoodsImages>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param GoodsImages
	 * @return
	 */
	public int saveGoodsImages(GoodsImages GoodsImages) ;
	/**
	 * 删除
	* @param GoodsImages
	* @return
	 */
	public int deleteGoodsImages(GoodsImages GoodsImages);


}
