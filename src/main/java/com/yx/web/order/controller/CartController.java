package com.yx.web.order.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yx.web.order.service.CartService;
import com.github.pagehelper.PageInfo;
import com.yx.web.order.model.Cart;
	/**
	 *	优惠劵管理
	 */
@Controller
@RequestMapping("/cart")
public class CartController {

	@Resource
	private CartService CartService;
	
	@RequestMapping
	public String toCart(Model model){
		return "order/cart/cart";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute Cart Cart) {
		return CartService.saveCart(Cart);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public  ModelAndView del(@ModelAttribute Cart Cart){
			CartService.deleteCart(Cart);
			 ModelAndView model = new ModelAndView("/mall/cartList");
			 List<Cart> cartList=CartService.selectOwnCart();
			 model.addObject("cartList", cartList);
			 return model;
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute Cart Cart, Model model) {
		PageInfo<Cart> page = CartService.selectPage(pageNum, pageSize, Cart);
		model.addAttribute("page", page);
		return "order/cart/cart-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		Cart cart = CartService.selectByPrimaryKey(id);
		model.addAttribute("cart", cart);
		return "order/cart/cart-save";
	}
	
}
