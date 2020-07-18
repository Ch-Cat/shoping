package com.yx.web.coupon.service;

import com.yx.common.base.BaseService;
import com.yx.web.coupon.model.CouponClass;

/**
 * 
 * @author
 */

public interface CouponClassService extends BaseService<CouponClass>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param CouponClass
	 * @return
	 */
	public int saveCouponClass(CouponClass CouponClass) ;
	/**
	 * 删除
	* @param CouponClass
	* @return
	 */
	public int deleteCouponClass(CouponClass CouponClass);


}
