package com.yx.web.base.service;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.Favorites;

/**
 * 
 * @author
 */

public interface FavoritesService extends BaseService<Favorites>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Favorites
	 * @return
	 */
	public int saveFavorites(Favorites Favorites) ;
	/**
	 * 删除
	* @param Favorites
	* @return
	 */
	public int deleteFavorites(Favorites Favorites);


}
