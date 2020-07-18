package com.yx.web.order.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yx.web.order.service.OrderCommonService;
import com.github.pagehelper.PageInfo;
import com.yx.web.order.model.OrderCommon;
	/**
	 *	订单管理
	 */
@Controller
@RequestMapping("orderCommon")
public class OrderCommonController {

	@Resource
	private OrderCommonService OrderCommonService;
	
	@RequestMapping
	public String toOrderCommon(Model model){
		return "order/orderCommon/orderCommon";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute OrderCommon OrderCommon) {
		return OrderCommonService.saveOrderCommon(OrderCommon);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute OrderCommon OrderCommon){
		return OrderCommonService.deleteOrderCommon(OrderCommon);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute OrderCommon OrderCommon, Model model) {
		PageInfo<OrderCommon> page = OrderCommonService.selectPage(pageNum, pageSize, OrderCommon);
		model.addAttribute("page", page);
		return "order/orderCommon/orderCommon-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		OrderCommon orderCommon = OrderCommonService.selectByPrimaryKey(id);
		model.addAttribute("orderCommon", orderCommon);
		return "order/orderCommon/orderCommon-save";
	}
	
}
