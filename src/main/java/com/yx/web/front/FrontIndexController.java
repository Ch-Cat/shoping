package com.yx.web.front;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.yx.common.constant.Constant;
import com.yx.common.utils.PasswordEncoder;
import com.yx.web.base.service.AddressService;
import com.yx.web.base.service.AreaService;
import com.yx.web.base.service.ConsultService;
import com.yx.web.base.service.PaymentService;
import com.yx.web.coupon.service.CouponService;
import com.yx.web.goods.model.Goods;
import com.yx.web.goods.model.GoodsClass;
import com.yx.web.goods.model.ShopType;
import com.yx.web.goods.service.GoodsClassService;
import com.yx.web.goods.service.GoodsService;
import com.yx.web.goods.service.ShopTypeService;
import com.yx.web.order.service.CartService;
import com.yx.web.order.service.OrderService;
import com.yx.web.sys.utils.SysUserUtils;
import com.yx.web.user.model.Member;
import com.yx.web.user.service.MemberService;
	/**
	 *	商品管理
	 */
@Controller
@RequestMapping("/front")
public class FrontIndexController {

	@Resource
	private GoodsClassService GoodsClassService;
	@Resource
	private GoodsService GoodsService;
	@Resource
	private ShopTypeService ShopTypeService;
	
	@Resource
	private MemberService MemberService;

	@Resource
	private CouponService CouponService;

	@Resource
	private OrderService OrderService;
	@Resource
	private AddressService AddressService;
	@Resource
	private PaymentService PaymentService;
	@Resource
	private ConsultService ConsultService;
	
	@Resource
	private CartService CartService;
	@Resource
	private AreaService AreaService;
	
	 @RequestMapping("")
	  public ModelAndView index() {
	        try {
	            ModelAndView model = new ModelAndView("/mall/home2");
	            Goods goods=new Goods();
	            PageInfo<Goods> page = GoodsService.selectPage(1, 4, goods);
	          
	            model.addObject("page", page);
	            GoodsClass gc=new GoodsClass();
	            gc.setParentId(1L);
	            List<GoodsClass> gcList=GoodsClassService.selectPage(1, 15, gc).getList();
	            ShopType sp=new ShopType();
	            sp.setParentId(1L);
	            List<ShopType> spList=ShopTypeService.selectPage(1, 2, sp).getList();
	            model.addObject("spList", spList);
	            model.addObject("gcList", gcList);
	            return model;
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("导航失败!");
	        }
	    }

	   /**
		 * 跳转到登录页面
		 * 
		 * @return
		 */
		@RequestMapping(value = "login", method = RequestMethod.GET)
		public String toLogin() {
			if( SysUserUtils.getSessionMemberUser() != null){
				return "redirect:/front";
			}
			return "/mall/login";
		}
		
		/**
		 * 登录验证
		 * 
		 * @param username
		 * @param password
		 * @param code
		 * @return
		 */
		@RequestMapping(value = "login", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> checkLogin(String username,
				String password,  HttpServletRequest request) {
			Map<String, Object> msg = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			//code = StringUtils.trim(code);
			username = StringUtils.trim(username);
			password = StringUtils.trim(password);
			//Object scode = session.getAttribute("code");
		//	String sessionCode = null;
//			if (scode != null)
//				sessionCode = scode.toString();
//			if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {
//				msg.put("error", "验证码错误");
//				return msg;
//			}
			Member user = MemberService.checkMember(username, password);
			if (null != user) {
				session.setAttribute(Constant.SESSION_Member_USER, user);
			} else {
				msg.put("error", "用户名或密码错误");
			}
			return msg;
		}
	 
		 /**
		 * 跳转到登录页面
		 * 
		 * @return
		 */
		@RequestMapping(value = "reg", method = RequestMethod.GET)
		public String reg() {
			if( SysUserUtils.getSessionMemberUser() != null){
				return "redirect:/front";
			}
			return "/mall/register";
		}
	
		//注册
		@RequestMapping(value = "reg", method = RequestMethod.POST)
		public @ResponseBody Map<String, Object> reg(
				@RequestParam(value = "password",required=true)String  password,
				@RequestParam(value = "email",required=false)String email,
				@RequestParam(value = "phone",required=false)String phone,
				@RequestParam(value = "passwordRepeat",required=true)String passwordRepeat,HttpServletRequest request) {
			Map<String, Object> msg = new HashMap<String, Object>();
			if (!StringUtils.equalsIgnoreCase(password, passwordRepeat)) {
				msg.put("error", "密码不一致!");
				return msg;
			}
			String secPwd = null ;
			//
			Member m=new Member();
			if(StringUtils.isNotBlank(email)){
				m.setMemberEmail(email);
				m.setMemberName(email);
				secPwd = PasswordEncoder.encrypt(password, email);
				//检查用户名是否存在
				List<Member> list = MemberService.select(m);
				if(list != null && list.size() == 1 && list.get(0) != null) {
					msg.put("error","用户名重复");
					return msg;
				}
			}
			if(StringUtils.isNotBlank(phone)){
				secPwd = PasswordEncoder.encrypt(password, phone);
				m.setMemberMobile(phone);
				m.setMemberName(phone);
				//检查用户名是否存在
				List<Member> list = MemberService.select(m);
				if(list != null && list.size() == 1 && list.get(0) != null) {
					msg.put("error","用户名重复");
					return msg;
				}
			}
			m.setMemberPasswd(secPwd);
			try {
				
				int result = MemberService.insertSelective(m);
				HttpSession session = request.getSession();
				if (result>0) {
					session.setAttribute(Constant.SESSION_Member_USER, m);
				} else {
					msg.put("error", "注册失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return msg;
		}
	 	/**
		 * 用户退出
		 * 
		 * @return 跳转到登录页面
		 */
		@RequestMapping("logout")
		public String logout(HttpServletRequest request) {
			request.getSession().invalidate();
			return "redirect:/front/login";
		}
	
		@RequestMapping("/search")
	  public ModelAndView search() {
		 ModelAndView model = new ModelAndView("/mall/search");
		 
		 
		 return model;
	 }
	
	 
}
