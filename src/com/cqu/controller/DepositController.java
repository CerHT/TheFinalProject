package com.cqu.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqu.entity.DepositRecordId;
import com.cqu.entity.Deposit_record;
import com.cqu.entity.Page;
import com.cqu.entity.User_inf;
import com.cqu.service.Deposit_recordService;
import com.cqu.service.User_infService;

@Controller
@RequestMapping("/deposit")
public class DepositController {

	@Autowired
	private Deposit_recordService deposit_recordService;
	
	@Autowired
	private User_infService user_infService;

	@RequestMapping("/show")
	public String showDepositRecord(HttpServletRequest request, ModelMap modelMap)
	{
		
		User_inf user_inf=user_infService.findByAdmin((int)request.getSession().getAttribute("idlogin"));
		System.out.println(user_inf.getBalance());
		request.setAttribute("u_balance", user_inf.getBalance());
		
		String pageNo = request.getParameter("pageNo");
		if (pageNo==null) {
			pageNo = "1";
		}
		Page page = deposit_recordService.findByU_idToPage((int)(request.getSession().getAttribute(("idlogin"))),Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<Deposit_record> list = page.getDeposit_records();
		System.out.println(list.size());
		modelMap.put("list", list);
//		User_inf user_inf=user_infService.findByAdmin((int)request.getSession().getAttribute("idlogin"));
//		request.setAttribute("u_balance", user_inf.getBalance());
		//request.getSession().setAttribute("list", list);
		return "user/user_recharge_inf";
	}
	
	@RequestMapping("/deposit")
	public String deposit(HttpServletRequest request)
	{
		int money=Integer.parseInt(request.getParameter("depositMoney"));
		DepositRecordId id=new DepositRecordId(new Date().toString(), (int)request.getSession().getAttribute("idlogin"));
		Deposit_record deposit_record=new Deposit_record(id, money);
		deposit_recordService.addDeposit_record(deposit_record);
		
		return "/depositSuccess";
	}
}
