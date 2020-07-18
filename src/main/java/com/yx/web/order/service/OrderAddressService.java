package com.yx.web.order.service;

import com.yx.common.base.BaseService;
import com.yx.web.order.model.OrderAddress;

/**
 * 
 * @author
 */

public interface OrderAddressService extends BaseService<OrderAddress>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderAddress
	 * @return
	 */
	public int saveOrderAddress(OrderAddress OrderAddress) ;
	/**
	 * 删除
	* @param OrderAddress
	* @return
	 */
	public int deleteOrderAddress(OrderAddress OrderAddress);


}
