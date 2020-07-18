package com.yx.web.goods.mapper;

import java.util.List;
import java.util.Map;

import com.github.abel533.mapper.Mapper;
import com.yx.web.goods.model.ShopType;


/**
 * 
 *	商品管理
 */
public interface ShopTypeMapper extends Mapper<ShopType>{

	public List<ShopType> findPageInfo(Map<String, Object> params);
}
