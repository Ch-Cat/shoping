package com.yx.web.user.service;

import com.yx.common.base.BaseService;
import com.yx.web.user.model.Invoice;

/**
 * 
 * @author
 */

public interface InvoiceService extends BaseService<Invoice>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Invoice
	 * @return
	 */
	public int saveInvoice(Invoice Invoice) ;
	/**
	 * 删除
	* @param Invoice
	* @return
	 */
	public int deleteInvoice(Invoice Invoice);


}
