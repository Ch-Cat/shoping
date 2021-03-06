package com.yx.web.order.service;

import com.yx.common.base.BaseService;
import com.yx.web.order.model.OrderGoods;

/**
 * 
 * @author
 */

public interface OrderGoodsService extends BaseService<OrderGoods>{

	

	
	/**
	 * 保存或更新
	 * 
	 * @param OrderGoods
	 * @return
	 */
	public int saveOrderGoods(OrderGoods OrderGoods) ;
	/**
	 * 删除
	* @param OrderGoods
	* @return
	 */
	public int deleteOrderGoods(OrderGoods OrderGoods);


}
