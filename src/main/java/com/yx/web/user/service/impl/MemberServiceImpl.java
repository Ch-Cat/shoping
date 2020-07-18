package com.yx.web.user.service.impl;

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
import com.yx.common.utils.PasswordEncoder;
import com.yx.web.user.service.MemberService;
import com.yx.web.user.mapper.MemberMapper;
import com.yx.web.user.model.Member;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;
import com.yx.web.sys.model.SysUser;

/**
 * 
 * @author
 */

@Service("MemberService")
public class MemberServiceImpl  extends ServiceMybatis<Member> implements MemberService {

	@Resource
	private MemberMapper MemberMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Member
	 * @return
	 */
	public int saveMember(Member Member) {
		return this.save(Member);
	}

	/**
	 * 删除
	* @param Member
	* @return
	 */
	public int deleteMember(Member Member) {
		return this.delete(Member);
	}

	@Override
	public Member checkMember(String username, String password) {
		Member sysUser = new Member();
		String secPwd = PasswordEncoder.encrypt(password, username);
		sysUser.setMemberName(username);
		sysUser.setMemberPasswd(secPwd);
		List<Member> users = this.select(sysUser);
		if(users != null && users.size() == 1 && users.get(0) != null) {
			return users.get(0);
		}
		return null;
	}


}
