package com.cqu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqu.entity.Business_inf;
import com.cqu.entity.Commodity_inf;
import com.cqu.entity.Page;
import com.cqu.entity.User_score;
import com.cqu.service.Business_infService;
import com.cqu.service.Commodity_infService;
import com.cqu.service.Spend_recordService;
import com.cqu.service.User_scoreService;

@Controller
@RequestMapping("/business")
public class BusinessController {
	
	@Autowired
	private Business_infService business_infService;
	
	@Autowired
	private User_scoreService user_scoreService;
	
	@Autowired
	private Spend_recordService spend_recordService;
	
	@Autowired
	private Commodity_infService commodity_infService;
	
	
	//update
	@RequestMapping("/update")
	public String UpdateBusiness(HttpSession session,HttpServletRequest request){
		Business_inf business_inf= business_infService.findByB_id((int)request.getSession().getAttribute("idlogin"));
		business_inf.setB_name(request.getParameter("b_name"));
		business_inf.setB_mail(request.getParameter("b_email"));
		business_inf.setB_add(request.getParameter("b_add"));
		business_inf.setB_tel(request.getParameter("b_tel"));
		business_inf.setB_type(request.getParameter("b_type"));
		business_inf.setScore_rate(Float.valueOf(request.getParameter("score_rate")));
		
		return "/success";
	}
	
	//显示商家信息
	@RequestMapping("/show")
	public String ShowBusiness(HttpSession session,HttpServletRequest request){
		Business_inf business_inf = business_infService.findByB_id((Integer)session.getAttribute("idlogin"));
		request.setAttribute("b_name",business_inf.getB_name());
		request.setAttribute("b_mail",business_inf.getB_mail());
		request.setAttribute("b_tel", business_inf.getB_tel());
		request.setAttribute("is_register", business_inf.getIs_register());
		request.setAttribute("score_rate", business_inf.getScore_rate());
		request.setAttribute("question", business_inf.getQuestion());
		request.setAttribute("request", business_inf.getRequest());
		business_infService.update(business_inf);
		return "/business/business_modify";
	}
	//展示商家的会员积分
	@RequestMapping("/listuserscore")
	public String listUser_score(HttpSession session ,HttpServletRequest request,ModelMap modelMap){
		
		String pageNo = request.getParameter("pageNo");
		if (pageNo==null) {
			pageNo = "1";
		}
		Page page = user_scoreService.findAllB_idToPage((Integer)session.getAttribute("idlogin"), Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<User_score> list = page.getUser_scores();
		modelMap.put("list", list);
		return "/business/business_score";
	}
	//展示消费情况
	@RequestMapping("/showconsume")
	public String ShowConsume(HttpSession session ,HttpServletRequest request,ModelMap modelMap){
		
		modelMap.put("list", spend_recordService.findByBusiness((Integer)session.getAttribute("b_idlogin")));
		return "/business/spendconsume";
	}
	
	//增加商品
	@RequestMapping("/addcommodity")
	public String addCommodity(Commodity_inf commodity_inf,HttpSession session ,HttpServletRequest request,ModelMap modelMap){
		commodity_infService.addCommodity(commodity_inf);
		return "/";
	}
	//删除商品
	@RequestMapping("/deletecommodity")
	public String deleteCommodity(Commodity_inf commodity_inf,HttpSession session ,HttpServletRequest request,ModelMap modelMap){
		commodity_infService.deleteCommodity(commodity_inf);
		return "/";
	}
	
	//显示商品
	@RequestMapping("/listcommodity")
	public String listCommodity(HttpSession session ,HttpServletRequest request,ModelMap modelMap){
		
		String pageNo = request.getParameter("pageNo");
		if (pageNo==null) {
			pageNo = "1";
		}
		Page page = commodity_infService.findByB_idToPage((Integer)session.getAttribute("idlogin"), Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<Commodity_inf> list = page.getCommodity_infs();
		modelMap.put("list", list);
		return "/business/commodity";
	}
	
}
