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
import com.yx.web.base.service.AdvPositionService;
import com.yx.web.base.mapper.AdvPositionMapper;

import com.yx.web.base.model.AdvPosition;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("AdvPositionService")
public class AdvPositionServiceImpl  extends ServiceMybatis<AdvPosition> implements AdvPositionService {

	@Resource
	private AdvPositionMapper AdvPositionMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param AdvPosition
	 * @return
	 */
	public int saveAdvPosition(AdvPosition AdvPosition) {
		return this.save(AdvPosition);
	}

	/**
	 * 删除
	* @param AdvPosition
	* @return
	 */
	public int deleteAdvPosition(AdvPosition AdvPosition) {
		return this.delete(AdvPosition);
	}


}
