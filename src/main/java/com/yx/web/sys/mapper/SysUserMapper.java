package com.yx.web.sys.mapper;


import java.util.List;
import java.util.Map;

import com.github.abel533.mapper.Mapper;
import com.yx.web.sys.model.SysUser;

/**
 * 
 * @author 
 */

public interface SysUserMapper extends Mapper<SysUser>{
	
	public List<SysUser> findPageInfo(Map<String, Object> params);
	
}
