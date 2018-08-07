package com.cqu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqu.entity.Business_inf;
import com.cqu.entity.Commodity_inf;
import com.cqu.entity.Page;
import com.cqu.service.Business_infService;
import com.cqu.service.Commodity_infService;

@Controller
@RequestMapping("/platform")
public class PlatFormController {

	@Autowired
	private Business_infService business_infService;
	
	@Autowired Commodity_infService commodity_infService;
	
	@RequestMapping("/business")
	public String findByBusiness(HttpServletRequest request,ModelMap modelMap){
		String pageNo = request.getParameter("pageNo");
		if (pageNo==null) {
			pageNo = "1";
		}
		Page page = business_infService.getAllToPage( Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<Business_inf> list = page.getBusiness_infs();
		modelMap.put("list", list);
		return "/platform/businesscomm";
	}
	
	@RequestMapping("/allcommodity")
	public String findAllByCommodity(HttpServletRequest request,ModelMap modelMap){
		String pageNo = request.getParameter("pageNo");
		if (pageNo==null) {
			pageNo = "1";
		}
		Page page = commodity_infService.findForPage( Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<Commodity_inf> list = page.getCommodity_infs();
		modelMap.put("list", list);
		return "/platform/allcommodity";
	}
	
	@RequestMapping("/commodity")
	public String findByCommodity(HttpServletRequest request,ModelMap modelMap){
		String pageNo = request.getParameter("pageNo");
		if (pageNo==null) {
			pageNo = "1";
		}															
		Page page = commodity_infService.findByC_nameToPage(request.getParameter("c_name"), Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<Commodity_inf> list = page.getCommodity_infs();
		modelMap.put("list", list);
		return "/platform/partcommodity";
	}
}
