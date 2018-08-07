package com.cqu.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cqu.entity.Page;
import com.cqu.entity.User_inf;
import com.cqu.entity.User_score;
import com.cqu.service.User_infService;
import com.cqu.service.User_scoreService;

/*
 * @author CHT
 * @date 创建时间：2017年7月17日 上午11:55:55
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private User_infService user_infService;
	
	@Autowired
	private User_scoreService user_scoreService;
	
	private String photoPath;
	
	public String getPhotoPath() {
		return photoPath;
	}
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}


	@RequestMapping("/updateuser")
	public String updateUser(HttpSession session,HttpServletRequest request) {
		User_inf user_inf=user_infService.findByAdmin((int)request.getSession().getAttribute("idlogin"));
		user_inf.setU_name(request.getParameter("u_name"));
		user_inf.setU_mail(request.getParameter("u_mail"));
		user_inf.setU_tel(request.getParameter("u_tel"));
		user_inf.setU_birth(Date.valueOf(request.getParameter("u_birth")));
		user_infService.updateUser_inf(user_inf);
		return "/success";
	}
	
	
	@RequestMapping("/uploadPhoto")
	public String upload(MultipartFile uploadFile,HttpServletRequest request,Map<String, Object> map)throws Exception
	{
		String filename = uploadFile.getOriginalFilename();

		String leftPath = request.getServletContext().getRealPath("/photo");

		File file = new File(leftPath, filename);
		uploadFile.transferTo(file);
		String savePath=request.getContextPath()+"/photo/"+filename;
		request.getSession().setAttribute("regist_uploadpicpath", savePath);
		//map.put("fileUploadPath", savePath);
		System.out.println(savePath);
		this.setPhotoPath(savePath);		
		return "user/userinf_modify";
	}
	
	@RequestMapping("/show")
	public String show(HttpServletRequest request)
	{
		User_inf user_inf=user_infService.findByAdmin((int)request.getSession().getAttribute("idlogin"));
		request.setAttribute("u_name", user_inf.getU_name());
		request.setAttribute("u_mail", user_inf.getU_mail());
		request.setAttribute("u_tel", user_inf.getU_tel());
		request.setAttribute("u_birth", user_inf.getU_birth());
		request.getSession().setAttribute("regist_uploadpicpath", user_inf.getU_photo());
		System.out.println(user_inf.getU_photo());
		return "user/userinf_modify";
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
//		return "/login";
	}
//	@RequestMapping("/listuserscore")
//	public String listUser_score(HttpSession session ,HttpServletRequest request,ModelMap modelMap){
//		
//		String pageNo = request.getParameter("pageNo");
//		if (pageNo==null) {
//			pageNo = "1";
//		}
//		Page page = user_scoreService.findAllToPage((Integer)session.getAttribute("ID"), Integer.parseInt(pageNo), 3);
//		request.setAttribute("page", page);
//		List<User_score> list = page.getUser_scores();
//		modelMap.put("list", list);
//		return "/";
//	}



	
}
