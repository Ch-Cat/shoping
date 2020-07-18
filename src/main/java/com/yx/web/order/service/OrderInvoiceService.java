package com.yx.web.order.service;

import com.yx.common.base.BaseService;
import com.yx.web.order.model.OrderInvoice;

/**
 * 
 * @author
 */

public interface OrderInvoiceService extends BaseService<OrderInvoice>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderInvoice
	 * @return
	 */
	public int saveOrderInvoice(OrderInvoice OrderInvoice) ;
	/**
	 * 删除
	* @param OrderInvoice
	* @return
	 */
	public int deleteOrderInvoice(OrderInvoice OrderInvoice);


}
