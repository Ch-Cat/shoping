package com.yx.web.base.mapper;


import com.yx.web.base.model.Address;

import com.github.abel533.mapper.Mapper;


/**
 * 
 *	基础管理
 */
public interface AddressMapper extends Mapper<Address>{

	void updateByMemberId(Address address);

}
