package com.cqu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqu.entity.Commodity_inf;
import com.cqu.service.Commodity_infService;

@Controller
@RequestMapping("/commodity")
public class CommodityController {

	@Autowired
	private Commodity_infService commodity_infService;
	
	@RequestMapping("/addcommodity")
	public String add(){
		Commodity_inf commodity_inf = new Commodity_inf();
		
		commodity_infService.addCommodity(commodity_inf);
		return "/success";
	}
}
