package com.yx.web.front;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.yx.common.constant.Constant;
import com.yx.common.json.JsonUtils;
import com.yx.common.redis.RedisUtils;
import com.yx.common.redis.bean.RedisGoods;
import com.yx.common.utils.IPUtils;
import com.yx.web.base.model.Address;
import com.yx.web.base.model.Area;
import com.yx.web.base.model.Payment;
import com.yx.web.base.service.AddressService;
import com.yx.web.base.service.AreaService;
import com.yx.web.base.service.PaymentService;
import com.yx.web.goods.model.Goods;
import com.yx.web.goods.service.GoodsService;
import com.yx.web.goods.service.GoodsSpecService;
import com.yx.web.order.model.Cart;
import com.yx.web.order.model.Order;
import com.yx.web.order.service.CartService;
import com.yx.web.order.service.OrderService;
import com.yx.web.sys.utils.SysUserUtils;
	/**
	 * 
	 *	商品管理
	 */
@Controller
@RequestMapping("front/goods")
public class GoodsFrontController {

	@Resource
	private GoodsService GoodsService;
	@Resource
	private GoodsSpecService GoodsSpecService;
	@Resource
	private AreaService AreaService;
	@Resource
	private CartService CartService;
	@Resource
	private AddressService AddressService;
	@Resource
	private PaymentService PaymentService;
	@Resource
	private OrderService OrderService;
	
	@RequestMapping("/goodsDetail/{id}")
	public ModelAndView goodsDetail(@PathVariable("id") Long id,HttpServletRequest req)throws Exception{
		ModelAndView mav=new ModelAndView();
		Goods goods=GoodsService.selectByPrimaryKey(id);
		mav.addObject("goods", goods);
		mav.setViewName("mall/goodsDetail");
		
		 Area area=new Area();
		 area.setParentId(1L);
		 List<Area> areas = AreaService.select(area);
		 mav.addObject("areas", areas);
		  
		 RedisGoods rg=new RedisGoods();
		 rg.setGoodsImage(goods.getGoodsImage());
		 rg.setGoodsName(goods.getGoodsName());
		 rg.setGoodsStorePrice(goods.getGoodsStorePrice());
		 rg.setId(goods.getId());
		 
		    String ip=IPUtils.getClientAddress(req);
		    RedisUtils  RedisUtils=new RedisUtils();
			RedisUtils.hset(Constant.SHOPPING_HISTORY + ip,id+"",JsonUtils.toJsonStr(rg),24*60*60);
		
//		String goodsSpec = goods.getGoodsSpec();
//		String specName = goods.getSpecName();
//		if(specName == null || specName.equals("")){
//			return null;
//		}
//		Map<String, String> specNameMap = JsonUtils.readJsonToMap(specName);
//		Map<String, List<GoodsSpecVo>> goodsSpecMap = GoodsUtils.goodsSpecStrToMapList(goodsSpec);
//		GoodsSpec sGoodsSpec=new GoodsSpec();
//		sGoodsSpec.setGoodsId(id);
//		List<GoodsSpec> goodsSpecs = GoodsSpecService.select(sGoodsSpec);
//        //规格颜色对应的图片
//        Map<String, String> goodsColImg = GoodsUtils.goodsColImgStrToMap(goods.getGoodsColImg());
//        //得到该商品的所有goodsvalueId的String,以逗号分割
//        for(int i = 0; i < goodsSpecs.size(); i++){
//        	goodsSpecs.get(i).setSpecValueIdStr(
//        			GoodsUtils.getThisGoodsAllSpecValueId(
//        					goodsSpecs.get(i).getSpecGoodsSpec()
//        			)
//        	);
//        }
//		Map<String, Object> specmap = new HashMap<String, Object>();
//		specmap.put("goodsColImg", goodsColImg);
//		specmap.put("specname", specNameMap);
//		specmap.put("specvalue", goodsSpecMap);
//		specmap.put("goodsSpecs", goodsSpecs);
		return mav;
	}
	
	
	
	 
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/goodsListBygcId/{gcId}")
	public ModelAndView goodsListBygcId(@PathVariable("gcId") Long gcId)throws Exception{
		ModelAndView mav=new ModelAndView();
		Goods g=new Goods();
		g.setGcId(gcId);
		PageInfo<Goods> page=GoodsService.selectPage(1, 40, g);
		mav.addObject("page", page);
		mav.setViewName("mall/search");
		return mav;
	}
	
	@RequestMapping("/goodsListBygcTypeId/{typeId}")
	public ModelAndView goodsListBygcTypeId(@PathVariable("typeId") Long typeId)throws Exception{
		ModelAndView mav=new ModelAndView();
		Goods g=new Goods();
		g.setTypeId(typeId);
		PageInfo<Goods> page=GoodsService.selectPage(1, 40, g);
		mav.addObject("page", page);
		mav.setViewName("mall/search");
		return mav;
	}
	
}
