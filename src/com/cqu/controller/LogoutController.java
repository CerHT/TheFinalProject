package com.cqu.controller;
/*
 * @author CHT
 * @date 创建时间：2017年9月26日 上午2:08:56
 * @version 1.0
 */

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
		
	}
}
