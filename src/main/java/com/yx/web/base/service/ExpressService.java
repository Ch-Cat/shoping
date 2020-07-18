package com.yx.web.base.service;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.Express;

/**
 * 
 * @author
 */

public interface ExpressService extends BaseService<Express>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Express
	 * @return
	 */
	public int saveExpress(Express Express) ;
	/**
	 * 删除
	* @param Express
	* @return
	 */
	public int deleteExpress(Express Express);


}
