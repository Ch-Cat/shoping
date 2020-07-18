package com.yx.web.test.service;

import com.yx.common.base.BaseService;
import com.yx.web.test.model.TestTree;

/**
 * 
 * @author
 */

public interface TestTreeService extends BaseService<TestTree>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param TestTree
	 * @return
	 */
	public int saveTestTree(TestTree TestTree) ;
	/**
	 * 删除
	* @param TestTree
	* @return
	 */
	public int deleteTestTree(TestTree TestTree);


}
