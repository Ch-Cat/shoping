package com.yx.web.goods.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.common.base.ServiceMybatis;
import com.yx.web.base.model.Favorites;
import com.yx.web.goods.mapper.GoodsMapper;
import com.yx.web.goods.model.Goods;
import com.yx.web.goods.service.GoodsService;

/**
 * 
 * @author
 */

@Service("GoodsService")
public class GoodsServiceImpl  extends ServiceMybatis<Goods> implements GoodsService {

	@Resource
	private GoodsMapper GoodsMapper;

	
	/**
	 * 保存或更新
	 * 
	 * @param Goods
	 * @return
	 */
	public int saveGoods(Goods Goods) {
		return this.save(Goods);
	}

	/**
	 * 删除
	* @param Goods
	* @return
	 */
	public int deleteGoods(Goods Goods) {
		return this.delete(Goods);
	}

	@Override
	public PageInfo<Goods> selectFavoritePageInfo(int i, int j, Favorites fa) {
		PageHelper.startPage(i, j);
		return  new PageInfo<Goods>(GoodsMapper.selectFavoritePageInfo(fa));
	}
	@Override
	public Goods selectIdGoods(Long id) {
		return GoodsMapper.selectByPrimaryKey(id);
	}
	/**
	 * 模糊查询
	 * @author
	 */
	@Override
	public List<Goods> seleName(String name) {
		
		Example example = new Example(Goods.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("goodsName", "%"+name+"%");
		List<Goods> listgoods = GoodsMapper.selectByExample(example);
		return listgoods;
	}

}
