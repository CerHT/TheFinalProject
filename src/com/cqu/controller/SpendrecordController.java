package com.cqu.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cqu.entity.Business_inf;
import com.cqu.entity.Commodity_inf;
import com.cqu.entity.Page;
import com.cqu.entity.SpendRecordId;
import com.cqu.entity.Spend_record;
import com.cqu.entity.User_inf;
import com.cqu.service.Commodity_infService;
import com.cqu.service.Spend_recordService;
import com.cqu.service.User_infService;

@Controller
@RequestMapping("/spendrecord")
public class SpendrecordController {

	
	@Autowired
	private Spend_recordService spend_recordService;
	
	@Autowired
	private Commodity_infService commodity_infService;
	
	@Autowired
	private User_infService user_infService;
	
	
	@RequestMapping("/show")
	public String findSpendByUser(HttpSession session ,HttpServletRequest request,ModelMap modelMap){
				
		String pageNo = request.getParameter("pageNo");
		if (pageNo==null) {
			pageNo = "1";
		}
		Page page = spend_recordService.findAllAboutToPage((Integer)session.getAttribute("idlogin"), Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);

		List<Spend_record> list = page.getSpend_records();
		modelMap.put("spend_list", list);
		
		return "/user/user_spend_inf";
	}
	

	@RequestMapping(params = "method=buy")
	public String buy(@RequestParam("id") String c_id,HttpServletRequest request) throws Exception
	{
		SpendRecordId id=new SpendRecordId(new Date().toString(),(int)request.getSession().getAttribute("idlogin") );
		Commodity_inf commodity_inf=commodity_infService.findByC_idByAdmin(Integer.parseInt(c_id));
		Spend_record spend_record=new Spend_record(id, commodity_inf, commodity_inf.getC_price(), (short)0, (short)0, 0f, 0, 1, commodity_inf.getC_price());
		spend_recordService.addSpend_record(spend_record);
		return "/buySuccess";
	}
}
