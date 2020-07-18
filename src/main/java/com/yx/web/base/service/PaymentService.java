package com.yx.web.base.service;

import com.yx.common.base.BaseService;
import com.yx.web.base.model.Payment;

/**
 * 
 * @author
 */

public interface PaymentService extends BaseService<Payment>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Payment
	 * @return
	 */
	public int savePayment(Payment Payment) ;
	/**
	 * 删除
	* @param Payment
	* @return
	 */
	public int deletePayment(Payment Payment);


}
