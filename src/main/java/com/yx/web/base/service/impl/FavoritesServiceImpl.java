package com.yx.web.base.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Multimap;
import com.google.common.collect.Table;
import com.yx.common.base.ServiceMybatis;
import com.yx.web.base.service.FavoritesService;
import com.yx.web.base.mapper.FavoritesMapper;

import com.yx.web.base.model.Favorites;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("FavoritesService")
public class FavoritesServiceImpl  extends ServiceMybatis<Favorites> implements FavoritesService {

	@Resource
	private FavoritesMapper FavoritesMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Favorites
	 * @return
	 */
	public int saveFavorites(Favorites Favorites) {
		return this.save(Favorites);
	}

	/**
	 * 删除
	* @param Favorites
	* @return
	 */
	public int deleteFavorites(Favorites Favorites) {
		return this.delete(Favorites);
	}


}
