package com.yx.web.order.service;

import java.math.BigDecimal;
import java.util.List;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.Address;
import com.yx.web.order.model.Order;

/**
 * 
 * @author
 */

public interface OrderService extends BaseService<Order>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Order
	 * @return
	 */
	public int saveOrder(Order Order) ;
	/**
	 * 删除
	* @param Order
	* @return
	 */
	public int deleteOrder(Order Order);
	public Order insertOrder(String[] cartIds,BigDecimal num,String address);


}
