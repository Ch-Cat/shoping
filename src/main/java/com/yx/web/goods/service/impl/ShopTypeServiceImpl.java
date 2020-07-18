package com.yx.web.goods.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.common.base.ServiceMybatis;
import com.yx.web.goods.mapper.ShopTypeMapper;
import com.yx.web.goods.model.ShopType;
import com.yx.web.goods.service.ShopTypeService;

/**
 * 
 * @author
 */

@Service("ShopTypeService")
public class ShopTypeServiceImpl  extends ServiceMybatis<ShopType> implements ShopTypeService {

	@Resource
	private ShopTypeMapper ShopTypeMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param ShopType
	 * @return
	 */
	public int saveShopType(ShopType ShopType) {
		return this.save(ShopType);
	}

	/**
	 * 删除
	* @param ShopType
	* @return
	 */
	public int deleteShopType(ShopType ShopType) {
		return this.delete(ShopType);
	}

	@Override
	public PageInfo<ShopType> findPageInfo(Map<String, Object> params) {
		PageHelper.startPage(params);
		List<ShopType> list = ShopTypeMapper.findPageInfo(params);
		return new PageInfo<ShopType>(list);
	}


}
