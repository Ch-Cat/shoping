package com.yx.web.user.service;

import com.yx.common.base.BaseService;
import com.yx.web.sys.model.SysUser;
import com.yx.web.user.model.Member;

/**
 * 
 * @author
 */

public interface MemberService extends BaseService<Member>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Member
	 * @return
	 */
	public int saveMember(Member Member) ;
	/**
	 * 删除
	* @param Member
	* @return
	 */
	public int deleteMember(Member Member);
	public Member checkMember(String username, String password);


}
