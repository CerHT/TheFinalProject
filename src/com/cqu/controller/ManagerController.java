package com.cqu.controller;
/*
 * @author CHT
 * @date 创建时间：2017年7月17日 上午11:12:38
 * @version 1.0
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqu.entity.Base_inf;
import com.cqu.entity.Business_inf;
import com.cqu.entity.Deposit_record;
import com.cqu.entity.Page;
import com.cqu.entity.Spend_record;
import com.cqu.entity.User_inf;
import com.cqu.entity.User_score;
import com.cqu.service.Base_infService;
import com.cqu.service.Business_infService;
import com.cqu.service.Commodity_infService;
import com.cqu.service.Deposit_recordService;
import com.cqu.service.Spend_recordService;
import com.cqu.service.User_infService;
import com.cqu.service.User_scoreService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private Base_infService base_infService;

	@Autowired
	private Business_infService business_infService;

	@Autowired
	private Commodity_infService commodity_infService;

	@Autowired
	private Deposit_recordService deposit_recordService;

	@Autowired
	private User_infService user_infService;

	@Autowired
	private User_scoreService user_scoreService;
	
	@Autowired
	private Spend_recordService spend_recordService;

	@RequestMapping("/findAll")
	public String findAll(HttpServletRequest request, ModelMap modelMap) {
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		Page page = base_infService.findForPage(Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<Base_inf> list = page.getBase_infs();
		modelMap.put("list", list);
		return "/manager/findAll";
	}

	@RequestMapping("/checkBusiness")
	public String checkBusiness(HttpServletRequest request, ModelMap modelMap) {
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		Page page = business_infService.findAll_not_registerToPage(Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<Business_inf> list = page.getBusiness_infs();
		modelMap.put("list", list);
		return "/manager/checkBussiness";
	}

	@RequestMapping("/findBusiness")
	public String findBussiness(HttpServletRequest request, ModelMap modelMap) {
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		Page page = business_infService.findAll_registerToPage(Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<Business_inf> list = page.getBusiness_infs();
		modelMap.put("list", list);
		return "/manager/findBussiness";
	}

	@RequestMapping("/findUser")
	public String findUser(HttpServletRequest request, ModelMap modelMap) {
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		Page page = user_infService.findForPage(Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<User_inf> list = page.getUser_infs();
		modelMap.put("list", list);
		return "/manager/findUser";
	}

	@RequestMapping("/findDeposit")
	public String findDeposit(HttpServletRequest request, ModelMap modelMap) {
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		Page page = deposit_recordService.findForPage(Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<Deposit_record> list = page.getDeposit_records();
		modelMap.put("list", list);
		return "/manager/findDeposit";
	}

	@RequestMapping("/findScore")
	public String findScore(HttpServletRequest request, ModelMap modelMap) {
		String pageNo = request.getParameter("pageNo");
		if (pageNo == null) {
			pageNo = "1";
		}
		Page page = user_scoreService.findForPage(Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<User_score> list = page.getUser_scores();
		modelMap.put("list", list);
		return "/manager/findScore";
	}

	@RequestMapping("/findSpend")
	public String findSpend(HttpServletRequest request, ModelMap modelMap) {
		String pageNo=request.getParameter("pageNo");
		if(pageNo==null) {
			pageNo="1";
		}
		Page page=spend_recordService.findForPage(Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<Spend_record> list=page.getSpend_records();
		modelMap.put("list", list);
		return "/manager/findScore";
	}
}
