package com.yx.web.base.service;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.AdvPosition;

/**
 * 
 * @author
 */

public interface AdvPositionService extends BaseService<AdvPosition>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param AdvPosition
	 * @return
	 */
	public int saveAdvPosition(AdvPosition AdvPosition) ;
	/**
	 * 删除
	* @param AdvPosition
	* @return
	 */
	public int deleteAdvPosition(AdvPosition AdvPosition);


}
