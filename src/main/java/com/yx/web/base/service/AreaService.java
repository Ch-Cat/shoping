package com.yx.web.base.service;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.Area;

/**
 * 
 * @author
 */

public interface AreaService extends BaseService<Area>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Area
	 * @return
	 */
	public int saveArea(Area Area) ;
	/**
	 * 删除
	* @param Area
	* @return
	 */
	public int deleteArea(Area Area);
	/**
	 * 根据id查询
	* @param Area
	* @return
	 */
	public Area selectId(long areaid);


}
