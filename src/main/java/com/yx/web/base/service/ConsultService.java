package com.yx.web.base.service;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.Consult;

/**
 * 
 * @author
 */

public interface ConsultService extends BaseService<Consult>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Consult
	 * @return
	 */
	public int saveConsult(Consult Consult) ;
	/**
	 * 删除
	* @param Consult
	* @return
	 */
	public int deleteConsult(Consult Consult);


}
