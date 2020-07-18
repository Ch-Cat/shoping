package com.yx.web.order.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yx.common.base.ServiceMybatis;
import com.yx.common.constant.Constant;
import com.yx.web.base.model.Address;
import com.yx.web.base.service.AreaService;
import com.yx.web.order.mapper.CartMapper;
import com.yx.web.order.mapper.OrderGoodsMapper;
import com.yx.web.order.mapper.OrderLogMapper;
import com.yx.web.order.mapper.OrderMapper;
import com.yx.web.order.model.Cart;
import com.yx.web.order.model.Order;
import com.yx.web.order.model.OrderGoods;
import com.yx.web.order.model.OrderLog;
import com.yx.web.order.service.OrderService;
import com.yx.web.sys.utils.SysUserUtils;

/**
 * 
 * @author
 */

@Service("OrderService")
public class OrderServiceImpl  extends ServiceMybatis<Order> implements OrderService {

	@Resource
	private OrderMapper OrderMapper;
	@Resource
	private CartMapper CartMapper;
	@Resource
	private OrderGoodsMapper OrderGoodsMapper;
	@Resource
	private OrderLogMapper OrderLogMapper;
	
	/**
	 * 保存或更新
	 * 
	 * @param Order
	 * @return
	 */
	public int saveOrder(Order Order) {
		return this.save(Order);
	}

	/**
	 * 删除
	* @param Order
	* @return
	 */
	public int deleteOrder(Order Order) {
		return this.delete(Order);
	}

	@Override
	public Order insertOrder(String[] cartIds,BigDecimal num,String address) {
		Order order=new Order();
		if(cartIds!=null && cartIds.length>0){
			
			order.setBuyerId(SysUserUtils.getSessionMemberUser().getId());
			order.setOrderSn(System.currentTimeMillis()+"");
			order.setStoreId(1L);
			order.setStoreName(Constant.STORE_NAME);
			order.setBuyerName(SysUserUtils.getSessionMemberUser().getMemberName());
			order.setBuyerEmail(null);
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			order.setCreateTime(format.format(new Date().getTime()));
			order.setOrderType(0);
			order.setOrderState(10);
			order.setOrderMessage("");//
			order.setPayId(1L);
			order.setPaymentId(1L);
			order.setOrderTotalPrice(num);
			order.setAddress(address);
			OrderMapper.insertSelective(order);
			
			OrderLog log=new OrderLog();
			log.setOrderId(order.getId());
			log.setOrderState("10");
			log.setStateInfo("提交订单");
			log.setCreateTime(new Date().getTime());
			log.setOperator(SysUserUtils.getSessionMemberUser().getMemberName());
			OrderLogMapper.insertSelective(log);
			
			for(String cartId:cartIds){
				Cart cart=CartMapper.selectByPrimaryKey(Long.parseLong(cartId));
				OrderGoods orderGoods=new OrderGoods();
				orderGoods.setOrderId(order.getId());
				orderGoods.setGoodsId(cart.getGoodsId());
				orderGoods.setGoodsImage(cart.getGoodsImages());
				orderGoods.setGoodsName(cart.getGoodsName());
				orderGoods.setGoodsPrice(cart.getGoodsStorePrice());
				orderGoods.setGoodsNum(cart.getGoodsNum());
				orderGoods.setBuyerId(SysUserUtils.getSessionMemberUser().getId());
				OrderGoodsMapper.insertSelective(orderGoods);
				//CartMapper.deleteByPrimaryKey(cart);
			}
		}
		return order;
		
	}


}
