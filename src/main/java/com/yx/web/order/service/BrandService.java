package com.yx.web.order.service;

import com.yx.common.base.BaseService;
import com.yx.web.order.model.Brand;

/**
 * 
 * @author
 */

public interface BrandService extends BaseService<Brand>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Brand
	 * @return
	 */
	public int saveBrand(Brand Brand) ;
	/**
	 * 删除
	* @param Brand
	* @return
	 */
	public int deleteBrand(Brand Brand);


}
