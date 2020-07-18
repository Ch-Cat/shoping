package com.yx.web.order.service;

import com.yx.common.base.BaseService;
import com.yx.web.order.model.OrderDaddress;

/**
 * 
 * @author
 */

public interface OrderDaddressService extends BaseService<OrderDaddress>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderDaddress
	 * @return
	 */
	public int saveOrderDaddress(OrderDaddress OrderDaddress) ;
	/**
	 * 删除
	* @param OrderDaddress
	* @return
	 */
	public int deleteOrderDaddress(OrderDaddress OrderDaddress);


}
