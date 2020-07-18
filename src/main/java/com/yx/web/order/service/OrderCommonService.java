package com.yx.web.order.service;

import com.yx.common.base.BaseService;
import com.yx.web.order.model.OrderCommon;

/**
 * 
 * @author
 */

public interface OrderCommonService extends BaseService<OrderCommon>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderCommon
	 * @return
	 */
	public int saveOrderCommon(OrderCommon OrderCommon) ;
	/**
	 * 删除
	* @param OrderCommon
	* @return
	 */
	public int deleteOrderCommon(OrderCommon OrderCommon);


}
