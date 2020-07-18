package com.yx.web.base.service;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.Adv;

/**
 * 
 * @author
 */

public interface AdvService extends BaseService<Adv>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Adv
	 * @return
	 */
	public int saveAdv(Adv Adv) ;
	/**
	 * 删除
	* @param Adv
	* @return
	 */
	public int deleteAdv(Adv Adv);


}
