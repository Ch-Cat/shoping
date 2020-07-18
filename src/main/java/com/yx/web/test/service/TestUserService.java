package com.yx.web.test.service;

import com.yx.common.base.BaseService;
import com.yx.web.test.model.TestUser;

/**
 * 
 * @author
 */

public interface TestUserService extends BaseService<TestUser>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param TestUser
	 * @return
	 */
	public int saveTestUser(TestUser TestUser) ;
	/**
	 * 删除
	* @param TestUser
	* @return
	 */
	public int deleteTestUser(TestUser TestUser);


}
