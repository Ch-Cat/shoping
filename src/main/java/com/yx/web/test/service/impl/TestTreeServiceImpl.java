package com.yx.web.test.service.impl;

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
import com.yx.web.test.service.TestTreeService;
import com.yx.web.test.mapper.TestTreeMapper;

import com.yx.web.test.model.TestTree;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;

/**
 * 
 * @author
 */

@Service("TestTreeService")
public class TestTreeServiceImpl  extends ServiceMybatis<TestTree> implements TestTreeService {

	@Resource
	private TestTreeMapper TestTreeMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param TestTree
	 * @return
	 */
	public int saveTestTree(TestTree TestTree) {
		return this.save(TestTree);
	}

	/**
	 * 删除
	* @param TestTree
	* @return
	 */
	public int deleteTestTree(TestTree TestTree) {
		return this.delete(TestTree);
	}


}
