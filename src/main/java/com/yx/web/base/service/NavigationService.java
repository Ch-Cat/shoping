package com.yx.web.base.service;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.Navigation;

/**
 * 
 * @author
 */

public interface NavigationService extends BaseService<Navigation>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Navigation
	 * @return
	 */
	public int saveNavigation(Navigation Navigation) ;
	/**
	 * 删除
	* @param Navigation
	* @return
	 */
	public int deleteNavigation(Navigation Navigation);


}
