package com.yx.web.order.service;

import com.yx.common.base.BaseService;
import com.yx.web.order.model.OrderLog;

/**
 * 
 * @author
 */

public interface OrderLogService extends BaseService<OrderLog>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderLog
	 * @return
	 */
	public int saveOrderLog(OrderLog OrderLog) ;
	/**
	 * 删除
	* @param OrderLog
	* @return
	 */
	public int deleteOrderLog(OrderLog OrderLog);


}
