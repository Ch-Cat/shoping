package com.yx.web.user.service;

import com.yx.common.base.BaseService;
import com.yx.web.user.model.MemberGrade;

/**
 * 
 * @author
 */

public interface MemberGradeService extends BaseService<MemberGrade>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param MemberGrade
	 * @return
	 */
	public int saveMemberGrade(MemberGrade MemberGrade) ;
	/**
	 * 删除
	* @param MemberGrade
	* @return
	 */
	public int deleteMemberGrade(MemberGrade MemberGrade);


}
