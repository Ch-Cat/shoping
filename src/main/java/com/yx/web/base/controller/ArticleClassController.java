package com.yx.web.base.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yx.web.base.service.ArticleClassService;
import com.github.pagehelper.PageInfo;
import com.yx.web.base.model.ArticleClass;
	
@Controller
@RequestMapping("articleClass")
public class ArticleClassController {

	@Resource
	private ArticleClassService ArticleClassService;
	
	@RequestMapping
	public String toArticleClass(Model model){
		return "base/articleClass/articleClass";
	}
	
	/**
	 * 添加或更新区域
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public @ResponseBody Integer save(@ModelAttribute ArticleClass ArticleClass) {
		return ArticleClassService.saveArticleClass(ArticleClass);
	}
	
	/**
	 * 删除字典
	* @param id
	* @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody Integer del(@ModelAttribute ArticleClass ArticleClass){
		return ArticleClassService.deleteArticleClass(ArticleClass);
	}
	
	/**
	 * 分页显示字典table
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(int pageNum,int pageSize,@ModelAttribute ArticleClass ArticleClass, Model model) {
		PageInfo<ArticleClass> page = ArticleClassService.selectPage(pageNum, pageSize, ArticleClass);
		model.addAttribute("page", page);
		return "base/articleClass/articleClass-list";
	}
	
	@RequestMapping(value="{mode}/showlayer",method=RequestMethod.POST)
	public String showLayer(Long id, Model model){
		ArticleClass articleClass = ArticleClassService.selectByPrimaryKey(id);
		model.addAttribute("articleClass", articleClass);
		return "base/articleClass/articleClass-save";
	}
	
}
