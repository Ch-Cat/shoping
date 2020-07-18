package com.yx.web.order.service;

import java.util.List;

import com.yx.common.base.BaseService;
import com.yx.web.order.model.Cart;

/**
 * 
 * @author
 */

public interface CartService extends BaseService<Cart>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param Cart
	 * @return
	 */
	public int saveCart(Cart Cart) ;
	/**
	 * 删除
	* @param Cart
	* @return
	 */
	public int deleteCart(Cart Cart);
	public Cart copyGoodsToCart(long goodsId, long specId);
	public List<Cart> selectOwnCart();
	public int selectOwnCartCount();


}
