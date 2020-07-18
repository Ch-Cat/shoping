package com.yx.web.order.service;

import com.yx.common.base.BaseService;
import com.yx.web.order.model.OrderPay;

/**
 * 
 * @author
 */

public interface OrderPayService extends BaseService<OrderPay>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderPay
	 * @return
	 */
	public int saveOrderPay(OrderPay OrderPay) ;
	/**
	 * 删除
	* @param OrderPay
	* @return
	 */
	public int deleteOrderPay(OrderPay OrderPay);


}
