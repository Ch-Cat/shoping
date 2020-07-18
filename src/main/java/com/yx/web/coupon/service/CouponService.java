package com.yx.web.coupon.service;

import com.yx.common.base.BaseService;
import com.yx.web.coupon.model.Coupon;

/**
 * 
 * @author
 */

public interface CouponService extends BaseService<Coupon>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Coupon
	 * @return
	 */
	public int saveCoupon(Coupon Coupon) ;
	/**
	 * 删除
	* @param Coupon
	* @return
	 */
	public int deleteCoupon(Coupon Coupon);


}
