package com.yx.web.coupon.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yx.web.coupon.service.CouponClassService;
import com.github.pagehelper.PageInfo;
import com.yx.web.coupon.model.CouponClass;
	/**
	 *
	 *	优惠劵管理
	 */
@Controller
@RequestMapping("couponClass")
public class CouponClassController {

	@Resource
	private CouponClassService CouponClassService;
	
	@RequestMapping
	public String toCouponClass(Model model){
		return "coupon/couponClass/couponClass";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute CouponClass CouponClass) {
		return CouponClassService.saveCouponClass(CouponClass);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute CouponClass CouponClass){
		return CouponClassService.deleteCouponClass(CouponClass);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute CouponClass CouponClass, Model model) {
		PageInfo<CouponClass> page = CouponClassService.selectPage(pageNum, pageSize, CouponClass);
		model.addAttribute("page", page);
		return "coupon/couponClass/couponClass-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		CouponClass couponClass = CouponClassService.selectByPrimaryKey(id);
		model.addAttribute("couponClass", couponClass);
		return "coupon/couponClass/couponClass-save";
	}
	
}
