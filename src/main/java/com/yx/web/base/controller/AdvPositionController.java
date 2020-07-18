package com.yx.web.base.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yx.web.base.service.AdvPositionService;
import com.github.pagehelper.PageInfo;
import com.yx.web.base.model.AdvPosition;
	
@Controller
@RequestMapping("advPosition")
public class AdvPositionController {

	@Resource
	private AdvPositionService AdvPositionService;
	
	@RequestMapping
	public String toAdvPosition(Model model){
		return "base/advPosition/advPosition";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute AdvPosition AdvPosition) {
		return AdvPositionService.saveAdvPosition(AdvPosition);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute AdvPosition AdvPosition){
		return AdvPositionService.deleteAdvPosition(AdvPosition);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute AdvPosition AdvPosition, Model model) {
		PageInfo<AdvPosition> page = AdvPositionService.selectPage(pageNum, pageSize, AdvPosition);
		model.addAttribute("page", page);
		return "base/advPosition/advPosition-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		AdvPosition advPosition = AdvPositionService.selectByPrimaryKey(id);
		model.addAttribute("advPosition", advPosition);
		return "base/advPosition/advPosition-save";
	}
	
}
