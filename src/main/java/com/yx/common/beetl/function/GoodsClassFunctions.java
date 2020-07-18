package com.yx.common.beetl.function;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yx.web.base.model.Area;
import com.yx.web.base.service.AreaService;
import com.yx.web.goods.model.Goods;
import com.yx.web.goods.model.GoodsClass;
import com.yx.web.goods.model.ShopType;
import com.yx.web.goods.service.GoodsClassService;
import com.yx.web.goods.service.GoodsService;
import com.yx.web.goods.service.ShopTypeService;
import com.yx.web.order.model.OrderGoods;
import com.yx.web.order.service.CartService;
import com.yx.web.order.service.OrderGoodsService;
import com.yx.web.sys.utils.SysUserUtils;

@Component
public class GoodsClassFunctions {
	
	@Resource
	private GoodsClassService goodsClassService;
	@Resource
	private ShopTypeService ShopTypeService;
	@Resource
	private GoodsService GoodsService;
	@Resource
	private OrderGoodsService OrderGoodsService;
	@Resource
	private CartService CartService;
	@Resource
	private AreaService AreaService;
	public List<GoodsClass> getGoodsClassListByPid(Long pid){
		GoodsClass gc=new GoodsClass();
		gc.setParentId(pid);
		return goodsClassService.select(gc);
	}
	public List<ShopType> getShopTypeListByPid(Long pid){
		ShopType gc=new ShopType();
		gc.setParentId(pid);
		return ShopTypeService.select(gc);
	}
	/**
	 * 根据商品类型查询商品
	 * @param tid
	 * @return
	 */
	public List<Goods> getGoodsListByTypeid(Long tid){
		Goods goods=new Goods();
		goods.setTypeId(tid);
		return GoodsService.selectPage(1, 6, goods).getList();
	}
	
	/**
	 * 根据goodsid查询商品
	 * @param tid
	 * @return
	 */
	public Goods getGoodsListByCartid(Long cid){
		return GoodsService.selectIdGoods(cid);
	}
	/**
	 * 根据订单查询商品
	 * @param tid
	 * @return
	 */
	public List<OrderGoods>  getGoodsListByorderid(Long oid){
		OrderGoods og=new OrderGoods();
		og.setOrderId(oid);
		
		return OrderGoodsService.select(og);
	}
	/**
	 * 得到购物车数量
	 * @return
	 */
	public int selectOwnCartCount(){
		return CartService.selectOwnCartCount();
	}
	/**
	 * 根据id查地方名
	 * @param tid
	 * @return
	 */
	public Area  getAddressByAreaid(Long aid){
		return AreaService.selectByPrimaryKey(aid);
	}
}
