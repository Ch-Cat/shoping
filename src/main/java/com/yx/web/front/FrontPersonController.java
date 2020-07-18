package com.yx.web.front;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.yx.common.constant.Constant;
import com.yx.common.json.JsonUtils;
import com.yx.common.redis.RedisUtils;
import com.yx.common.redis.bean.RedisGoods;
import com.yx.common.utils.IPUtils;
import com.yx.web.base.model.Address;
import com.yx.web.base.model.Area;
import com.yx.web.base.model.Consult;
import com.yx.web.base.model.Favorites;
import com.yx.web.base.model.Payment;
import com.yx.web.base.service.AddressService;
import com.yx.web.base.service.AreaService;
import com.yx.web.base.service.ConsultService;
import com.yx.web.base.service.FavoritesService;
import com.yx.web.base.service.PaymentService;
import com.yx.web.coupon.model.Coupon;
import com.yx.web.coupon.service.CouponService;
import com.yx.web.goods.mapper.GoodsClassMapper;
import com.yx.web.goods.mapper.GoodsMapper;
import com.yx.web.goods.model.Goods;
import com.yx.web.goods.model.GoodsClass;
import com.yx.web.goods.service.GoodsClassService;
import com.yx.web.goods.service.GoodsService;
import com.yx.web.goods.service.ShopTypeService;
import com.yx.web.order.mapper.CartMapper;
import com.yx.web.order.model.Cart;
import com.yx.web.order.model.Order;
import com.yx.web.order.service.CartService;
import com.yx.web.order.service.OrderService;
import com.yx.web.sys.utils.SysUserUtils;
import com.yx.web.user.model.Member;
import com.yx.web.user.service.MemberService;
	/**
	 * 
	 *	商品管理
	 */
@Controller
@RequestMapping("/person")
public class FrontPersonController {

	@Resource
	private GoodsClassService GoodsClassService;
	@Resource
	private GoodsService GoodsService;
	@Resource
	private ShopTypeService ShopTypeService;
	@Resource
	private CouponService CouponService;
	@Resource
	private MemberService MemberService;
	@Resource
	private OrderService OrderService;
	@Resource
	private AddressService AddressService;
	@Resource
	private PaymentService PaymentService;
	@Resource
	private ConsultService ConsultService;
	@Resource
	private FavoritesService FavoritesService;
	@Resource
	private AreaService AreaService;
	@Resource
	private CartService CartService;
	@Resource
	private GoodsMapper GoodsMapper;
	@Resource
	private GoodsClassMapper GoodsClassMapper;
	@Resource
	private CartMapper CartMapper;
	 @RequestMapping("")
	  public ModelAndView index() {
	        try {
	            ModelAndView model = new ModelAndView("/mall/person/index");
	            Member member=SysUserUtils.getSessionMemberUser();
	            model.addObject("member", member);
	           
	            return model;
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("导航失败!");
	        }
	    }
	 /**
	  * 个人信息
	  * @return
	  */
	 @RequestMapping("/information")
	  public ModelAndView information() {
		 ModelAndView model = new ModelAndView("/mall/person/information");
         Member member=SysUserUtils.getSessionMemberUser();
         model.addObject("member", member);
		 
         Area area=new Area();
		 area.setParentId(1L);
		 List<Area> areas = AreaService.select(area);
		 model.addObject("areas", areas);
		 
		 return model;
	 }
	 /**
	  * 更新个人信息
	  * @return
	  */
	 @RequestMapping("/member")
	  public ModelAndView upMember(String memberTruename,String memberSex,String memberBirthday,String memberQq,String memberEmail) {
		 ModelAndView model = new ModelAndView("/mall/person/information");
		 Member member=new Member();
		 
		 member.setId(SysUserUtils.getSessionMemberUser().getId());;
		 member.setMemberTruename(memberTruename);
		 member.setMemberSex(memberSex);
		 member.setMemberBirthday(memberBirthday);
		 member.setMemberQq(memberQq);
		 member.setMemberEmail(memberEmail);
		 MemberService.updateByPrimaryKeySelective(member);
		 
		 Member mb=SysUserUtils.getSessionMemberUser();
         model.addObject("member", mb);
		 
		 return model;
	 }
	 
	 
	 /**
	     * 根据父类ID 获取到 下级城市
	     *
	     * @param @param  parentid
	     * @param @return
	     * @param @throws JsonGenerationException
	     * @param @throws JsonMappingException
	     * @param @throws Exception    设定文件
	     * @return Map<String,String>    返回类型
	     * @throws
	     * @Title: getChildArea
	     * @Description: TODO(这里用一句话描述这个方法的作用)
	     */
	    @RequestMapping(value = "/getChildArea", method = RequestMethod.POST)
	    public
	    @ResponseBody
	    Map<String, String> getChildArea(@RequestParam(value = "id") String parentid) throws JsonGenerationException, JsonMappingException,
	            Exception {
	        Map<String, String> map = Maps.newHashMap();
	        Area area=new Area();
	        area.setParentId(Long.valueOf(parentid));
	        List<Area> areas = AreaService.select(area);
	        String json = "null";
	        String str[]={"areaSort"};
	        if (areas != null && areas.size() > 0) {
	            json = JsonUtils.toJsonStrWithExcludeProperties(areas,str);
	        }
	        map.put("result", json);
	        map.put("success", "true");
	        return map;
	    }
	 /**
	  * 地址管理
	  * @return
	  */
	 @RequestMapping("/address")
	  public ModelAndView address() {
		 ModelAndView model = new ModelAndView("/mall/person/address");
		 List<Address> addressList= AddressService.selectByMemberId();
		 model.addObject("page", addressList);
		 List<Area> areas=new ArrayList<Area>();
		 for(long i=1;i<16;i++) {
			 areas.add(AreaService.selectByPrimaryKey(i));
		 }
		 
		// List<Area> areas = AreaService.select(area);
		 model.addObject("areas", areas);
		 return model;
	 }
	 /**
	 *
	 * @Title: saveAddress
	 * @Description: TODO
	 * @param @param jsondata
	 * @param @param model
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	@RequestMapping(value = "/saveAddress", method = RequestMethod.POST)
	public String saveAddress(@ModelAttribute Address address) throws Exception {
		address.setIsDefault("0");
		address.setMemberId(SysUserUtils.getSessionMemberUser().getId());
		AddressService.saveAddress(address);
		return "redirect:/person/address";
		
	}
	 /**
		 * 
		 * @Title: updateDef
		 * @Description: 根据收货地址id和用户id修改默认收货地址
		 * @param @param addressId
		 * @param @param model
		 * @param @return
		 * @param @throws Exception 设定文件
		 * @return Map<String,String> 返回类型
		 * @throws
		 */
	 @RequestMapping(value = "/setAddressDef", method = RequestMethod.POST)
		public @ResponseBody
		Map<String, String> updateDef(@RequestParam(value = "addressId") String addressId) throws Exception {

			Map<String, String> map = Maps.newHashMap();
			int result = AddressService.updateDef(addressId, SysUserUtils.getSessionMemberUser().getId().toString());
			if(result == 1){
				map.put("success", "true");
			}else{
				map.put("success", "false");
			}
			return map;
		}
 
	 /**
	  * 订单管理
	  * @return
	  */
	 @RequestMapping("/order/{orderStats}")
	  public ModelAndView order(@RequestParam(value = "orderStats",required=false,defaultValue="10") Integer orderStats) {
		 ModelAndView model = new ModelAndView("/mall/person/order");
		 Order order=new Order();
		 //所有订单
		 PageInfo<Order> orderList=OrderService.selectPage(1, 5, order);
		 model.addObject("page", orderList);
		
		 return model;
	 }
	 
	

	
	 /**
	  * 足迹
	  * @return
	  
	 @RequestMapping("/foot")
	  public ModelAndView foot(HttpServletRequest req) {
		 ModelAndView model = new ModelAndView("/mall/person/foot");
		  String ip=IPUtils.getClientAddress(req);
		    RedisUtils  RedisUtils=new RedisUtils();
			Map<String, String> map=RedisUtils.hgetall(Constant.SHOPPING_HISTORY+ip);
			List<String> l=JsonUtils.testMap2List(map);
			List<RedisGoods> goodsList=new ArrayList<RedisGoods>();
			for (int i=0;i<l.size();i++){
				String json=(String)l.get(i);
				goodsList.add(JsonUtils.fromJson(json, RedisGoods.class));
			}
			model.addObject("goodsList",goodsList);
		 return model;
	 }
*/
	

	 /**
	  * 购物车
	 * @return
	 */
	@RequestMapping("/cartList")
	  public ModelAndView cartList() {
		 ModelAndView model = new ModelAndView("/mall/cartList");
		 List<Cart> cartList=CartService.selectOwnCart();
		 BigDecimal num = new BigDecimal(0);
			for (Cart cart2 : cartList) {
				num=num.add(cart2.getGoodsStorePrice());
			}
			
		 model.addObject("num", num);
		 model.addObject("cartList", cartList);
		 return model;
	 }
	@RequestMapping("/cartList1")
	  public ModelAndView cartList(long goodsid,long number) {
		 ModelAndView model = new ModelAndView("/mall/cartList");
		
		 CartService.copyGoodsToCart(goodsid, number);
		 List<Cart> cartList=CartService.selectOwnCart();
		 BigDecimal num = new BigDecimal(0);
			for (Cart cart2 : cartList) {
				num=num.add(cart2.getGoodsStorePrice());
			}
			
		 model.addObject("num", num);
		 model.addObject("cartList", cartList);
		 return model;
	 }
	/**
	  * 立即购买
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/LikBuy1")
		public ModelAndView LikBuy( long goodsid,long number,
				 HttpSession session)throws Exception{
			ModelAndView mav=new ModelAndView();
			Goods goods = GoodsMapper.selectByPrimaryKey(goodsid); //商品信息
			
			GoodsClass goodsClass = GoodsClassMapper.selectByPrimaryKey(goods.getGcId()); //通过商品分类id查询商品所在分类
	        
			Cart cart = new Cart();
			cart.setGoodsId(goods.getId());
			cart.setMemberId(SysUserUtils.getSessionMemberUser().getId());
			cart.setGoodsNum(number);
			cart.setGoodsName(goods.getGoodsName());
			BigDecimal num1 = new BigDecimal(0);
			for(long i=0;i<number;i++) {
				num1=num1.add(goods.getGoodsStorePrice());
			}
			cart.setGoodsStorePrice(num1);
			cart.setStoreId(goods.getStoreId());
			cart.setStoreName(Constant.STORE_NAME);
			String[] gcIds = goodsClass.getGcIdpath().split(",");
			cart.setFirstGcId(Long.valueOf(gcIds[0])); //将商品所在分类的一级分类的id存入购物车
			CartMapper.insert(cart);
			
			
			List<Cart> cartList = CartService.select(cart);
			
			
		    mav.addObject("num", num1);
			mav.addObject("cartList", cartList);
			
			List<Address> addressList= AddressService.selectByMemberIdAnddefa();
			mav.addObject("addressList", addressList);
			 
			Payment Payment=new Payment();
		    Payment.setIsDel(1);
			List<Payment> payList=PaymentService.select(Payment);
			mav.addObject("payList", payList);
			 
			mav.setViewName("mall/LikBuy");
			return mav;
		}
	 /**
	  * 结算
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/LikBuy")
		public ModelAndView goodsDetail(HttpSession session)throws Exception{
			ModelAndView mav=new ModelAndView();
			
			Cart cart = new Cart();
			//当前登陆的用户
			cart.setMemberId(SysUserUtils.getSessionMemberUser().getId());
			
			List<Cart> cartList=CartService.select(cart);
			BigDecimal num = new BigDecimal(0);
			for (Cart cart2 : cartList) {
				num=num.add(cart2.getGoodsStorePrice());
			}
			
			mav.addObject("num", num);
			mav.addObject("cartList", cartList);
			
			List<Address> addressList= AddressService.selectByMemberIdAnddefa();
			mav.addObject("addressList", addressList);
			 
			Payment Payment=new Payment();
		    Payment.setIsDel(1);
			List<Payment> payList=PaymentService.select(Payment);
			mav.addObject("payList", payList);
			 
			mav.setViewName("mall/LikBuy");
			return mav;
		}
	 /**
	  * 提交订单
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("submitOrder")
		public ModelAndView submitOrder(@RequestParam(value = "cartIds") String[] cartIds)throws Exception{
			ModelAndView mav=new ModelAndView();
			
			//总金额
			BigDecimal num = new BigDecimal(0);
			for (String string : cartIds) {
				System.out.println(string);
				Long cartid = Long.parseLong(string);
				Cart cart = CartService.selectByPrimaryKey(cartid);
				System.out.println(cart);
				num=num.add(cart.getGoodsStorePrice());
			}
			//获取下订单的地址
			List<Address> addresslist= AddressService.selectByMemberIdAnddefa();
			String s=null;
			for (Address address : addresslist) {
				Area area = AreaService.selectId(address.getAreaInfo());
				s=area.getAreaName()+address.getAddress();
			}
			Order order=OrderService.insertOrder(cartIds,num,s);
			
			List<Address> addressList= AddressService.selectByMemberIdAnddefa();
			mav.addObject("addressList", addressList);
			mav.setViewName("mall/success");
			mav.addObject("order", order);
			//删除购物车
			for (String string : cartIds) {
				long id = Long.parseLong(string);
				CartService.deleteByPrimaryKey(id);
			}
			return mav;
		}
	 /**
	  * 查看已买到的宝贝
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/selledGoods/{id}")
		public ModelAndView selledGoods(@PathVariable("id") Long id)throws Exception{
			ModelAndView mav=new ModelAndView();
			Goods b=GoodsService.selectByPrimaryKey(id);
			mav.addObject("goods", b);
			mav.setViewName("mall/person/order");
			return mav;
		}
	 /**
	  *交易详情
	  * @param id
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping("/orderDetail/{id}")
		public ModelAndView orderDetail(@PathVariable("id") Long id)throws Exception{
			ModelAndView mav=new ModelAndView();
			Goods b=GoodsService.selectByPrimaryKey(id);
			mav.addObject("goods", b);
			mav.setViewName("mall/person/orderinfo");
			return mav;
		}
	 /**
		 * 删除cart
		* @param id
		* @return
		 */
		@RequestMapping(value="/delete/{cartId}")
		public  ModelAndView del(@PathVariable("cartId") long cartId){
			CartService.deleteByPrimaryKey(cartId);
			ModelAndView model = new ModelAndView("/mall/cartList");
			List<Cart> cartList=CartService.selectOwnCart();
			model.addObject("cartList", cartList);
			return model;
		}
		 /**
		 * 删除order
		* @param id
		* @return
		 */
		@RequestMapping(value="/orderdel/{orderId}")
		public  ModelAndView orderdel(@PathVariable("orderId") long orderId){
			OrderService.deleteByPrimaryKey(orderId);
			
			 ModelAndView model = new ModelAndView("/mall/person/order");
			 Order order=new Order();
			 //所有订单
			 PageInfo<Order> orderList=OrderService.selectPage(1, 5, order);
			 model.addObject("page", orderList);
			
			 return model;
		}
		 /**
		 * 删除address
		* @param id
		* @return
		 */
		@RequestMapping(value="/addressdel/{addressId}")
		public  ModelAndView addressdel(@PathVariable("addressId") long addressId){
			Address ad=new Address();
			ad.setId(addressId);
			AddressService.deleteAddress(ad);
			
			 ModelAndView model = new ModelAndView("/mall/person/address");
	
			 return model;
		}
		 /**
		 * 搜索商品
		 * 
		* @param id
		* @return
		 */
		@RequestMapping(value="/seleName")
		public  ModelAndView seleName(String name){
			ModelAndView model = new ModelAndView("/mall/search");
			List<Goods> goodslist = GoodsService.seleName(name);
			System.out.println(name);
			model.addObject("goodslist", goodslist);
			
			return model;
		}
}
