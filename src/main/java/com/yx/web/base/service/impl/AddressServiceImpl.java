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
import com.yx.web.base.service.AddressService;
import com.yx.web.base.mapper.AddressMapper;
import com.yx.web.base.model.Address;
import com.yx.web.sys.model.SysOffice;
import com.yx.web.sys.model.SysRole;
import com.yx.web.sys.utils.SysUserUtils;

/**
 * 
 * @author
 */

@Service("AddressService")
public class AddressServiceImpl  extends ServiceMybatis<Address> implements AddressService {

	@Resource
	private AddressMapper AddressMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Address
	 * @return
	 */
	public int saveAddress(Address Address) {
		return this.save(Address);
	}

	/**
	 * 删除
	* @param Address
	* @return
	 */
	public int deleteAddress(Address Address) {
		return this.delete(Address);
	}
	
	@Override
	public int updateDef(String addressId, String memberId) {
		int result = 0;
        if (addressId != null) {
            Address address = new Address();
            address.setMemberId(Long.valueOf(memberId));
            address.setIsDefault("0");
            AddressMapper.updateByMemberId(address);
            address.setMemberId(null);
            address.setId(Long.valueOf(addressId));
            address.setIsDefault("1");
            this.updateByPrimaryKeySelective(address);
            result = 1;
        }
        return result;
	}
	@Override
	public List<Address> selectByMemberId() {
		 Address Address=new Address();
		 Address.setMemberId(SysUserUtils.getSessionMemberUser().getId());
		return  this.select(Address);
	}

	@Override
	public List<Address> selectByMemberIdAnddefa() {
		 Address Address=new Address();
		 Address.setIsDefault("1");
		 Address.setMemberId(SysUserUtils.getSessionMemberUser().getId());
		return  this.select(Address);
	}



}
