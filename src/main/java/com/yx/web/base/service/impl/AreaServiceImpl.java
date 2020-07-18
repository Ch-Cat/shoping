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
import com.yx.web.base.service.AreaService;
import com.yx.web.base.mapper.AreaMapper;

import com.yx.web.base.model.Area;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("AreaService")
public class AreaServiceImpl  extends ServiceMybatis<Area> implements AreaService {

	@Resource
	private AreaMapper AreaMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Area
	 * @return
	 */
	public int saveArea(Area Area) {
		return this.save(Area);
	}

	/**
	 * 删除
	* @param Area
	* @return
	 */
	public int deleteArea(Area Area) {
		return this.delete(Area);
	}
	/**
	 * 根据id查询
	* @param Area
	* @return
	 */
	public Area selectId(long areaid) {
		return this.selectByPrimaryKey(areaid);
	}


}
