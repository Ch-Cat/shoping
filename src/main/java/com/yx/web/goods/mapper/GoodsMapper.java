package com.yx.web.goods.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;

import com.yx.web.base.model.Favorites;
import com.yx.web.goods.model.Goods;





/**
 * 
 *	商品管理
 */
public interface GoodsMapper extends Mapper<Goods>{

	List<Goods> selectFavoritePageInfo(Favorites fa);
	
}
