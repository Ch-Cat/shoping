package com.yx.web.base.service;

import java.util.List;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.Address;

/**
 * 
 * @author
 */

public interface AddressService extends BaseService<Address>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Address
	 * @return
	 */
	public int saveAddress(Address Address) ;
	/**
	 * 删除
	* @param Address
	* @return
	 */
	public int deleteAddress(Address Address);
	public int updateDef(String addressId, String string);
	public List<com.yx.web.base.model.Address> selectByMemberId();
	public List<com.yx.web.base.model.Address> selectByMemberIdAnddefa();


}
