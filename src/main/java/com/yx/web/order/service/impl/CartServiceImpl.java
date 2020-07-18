package com.yx.web.order.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.yx.common.base.ServiceMybatis;
import com.yx.common.constant.Constant;
import com.yx.web.goods.mapper.GoodsClassMapper;
import com.yx.web.goods.mapper.GoodsMapper;
import com.yx.web.goods.model.Goods;
import com.yx.web.goods.model.GoodsClass;
import com.yx.web.goods.model.GoodsSpec;
import com.yx.web.goods.util.GoodsUtils;
import com.yx.web.order.mapper.CartMapper;
import com.yx.web.order.model.Cart;
import com.yx.web.order.service.CartService;
import com.yx.web.sys.utils.SysUserUtils;

/**
 * 购物车
 * @author
 */

@Service("CartService")
public class CartServiceImpl  extends ServiceMybatis<Cart> implements CartService {

	@Resource
	private CartMapper CartMapper;
	@Resource
	private GoodsMapper GoodsMapper;
	@Resource
	private GoodsClassMapper GoodsClassMapper;
	
	/**
	 * 保存或更新
	 * 
	 * @param Cart
	 * @return
	 */
	public int saveCart(Cart Cart) {
		return this.save(Cart);
	}

	/**
	 * 删除
	* @param Cart
	* @return
	 */
	public int deleteCart(Cart Cart) {
		return this.delete(Cart);
	}

	@Override
	public Cart copyGoodsToCart(long goodsId, long number) {
		Goods goods = GoodsMapper.selectByPrimaryKey(goodsId); //商品信息
		
		GoodsClass goodsClass = GoodsClassMapper.selectByPrimaryKey(goods.getGcId()); //通过商品分类id查询商品所在分类
        
		Cart cart = new Cart();
		cart.setGoodsId(goods.getId());
		cart.setMemberId(SysUserUtils.getSessionMemberUser().getId());
		Cart alCart=CartMapper.selectOne(cart);
		if(alCart!=null){	
			alCart.setGoodsNum(alCart.getGoodsNum()+number);
			alCart.setGoodsStorePrice(alCart.getGoodsStorePrice().add(goods.getGoodsStorePrice()));
			System.out.println(goods);
			CartMapper.updateByPrimaryKeySelective(alCart);
		}else{
			cart.setGoodsNum(number);
			cart.setGoodsName(goods.getGoodsName());
			BigDecimal num = new BigDecimal(0);
			for(long i=0;i<number;i++) {
				num=num.add(goods.getGoodsStorePrice());
			}
			cart.setGoodsStorePrice(num);
			cart.setStoreId(goods.getStoreId());
			cart.setStoreName(goods.getStoreName());
			String[] gcIds = goodsClass.getGcIdpath().split(",");
			cart.setFirstGcId(Long.valueOf(gcIds[0])); //将商品所在分类的一级分类的id存入购物车
			CartMapper.insertSelective(cart);
		}

		return cart;
	}

	@Override
	public List<Cart> selectOwnCart() {
		if(SysUserUtils.getSessionMemberUser()!=null){
			Cart cart=new Cart();
			cart.setMemberId(SysUserUtils.getSessionMemberUser().getId());
			return CartMapper.select(cart);
		}
		return null;
		
	}
	@Override
	public int selectOwnCartCount() {
		if(SysUserUtils.getSessionMemberUser()!=null){
			Cart cart=new Cart();
			cart.setMemberId(SysUserUtils.getSessionMemberUser().getId());
			return CartMapper.selectCount(cart);
		}
		return 0;
		
	}

}
