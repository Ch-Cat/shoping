package com.yx.web.goods.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.yx.common.base.BaseService;
import com.yx.web.base.model.Favorites;
import com.yx.web.goods.model.Goods;

public interface GoodsService extends BaseService<Goods>{
	
	/**
	 * 保存或更新
	 * 
	 * @param Goods
	 * @return
	 */
	public int saveGoods(Goods Goods) ;
	/**
	 * 删除
	* @param Goods
	* @return
	 */
	public int deleteGoods(Goods Goods);
	public PageInfo<Goods> selectFavoritePageInfo(int i, int j, Favorites fa);
	/**
	 * 根据id查goods
	 * @author
	 */
	public Goods selectIdGoods(Long id);
	/**
	 * 模糊查询
	 * @author
	 */
	public List<Goods> seleName(String name);
}
