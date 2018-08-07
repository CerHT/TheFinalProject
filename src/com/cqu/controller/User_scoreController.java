package com.cqu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cqu.entity.Page;
import com.cqu.entity.User_score;
import com.cqu.service.User_scoreService;

/*
 * @author CHT
 * @date 创建时间：2017年7月17日 上午10:29:37
 * @version 1.0
 */
@Controller
@RequestMapping("/user_score")
public class User_scoreController {

	@Autowired 
	private User_scoreService user_scoreService;
	
	
	@RequestMapping("/show")
	public String listUser_score(HttpSession session ,HttpServletRequest request,ModelMap modelMap){
		
		String pageNo = request.getParameter("pageNo");
		if (pageNo==null) {
			pageNo = "1";
		}
		Page page = user_scoreService.findAllToPage((Integer)session.getAttribute("idlogin"), Integer.parseInt(pageNo), 3);
		request.setAttribute("page", page);
		List<User_score> list = page.getUser_scores();
		modelMap.put("list", list);
		return "/user/user_score_inf";
	}
}
