package com.cqu.controller;

import java.io.File;
import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cqu.entity.Base_inf;
import com.cqu.entity.Business_inf;
import com.cqu.entity.User_inf;
import com.cqu.service.Base_infService;
import com.cqu.service.Business_infService;
import com.cqu.service.User_infService;

@Controller
@RequestMapping("/base")
public class BaseController{

	@Autowired 
	private Base_infService base_infService;
	
	@Autowired
	private User_infService user_infService;
	
	@Autowired
	private Business_infService business_infService;
	
	private String photoPath;
	
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@RequestMapping("/addbusiness")
	public String addbusiness(HttpServletRequest request){	
		if(base_infService.put_up_register_business(request.getParameter("regist_account"),request.getParameter("regist_password"))){
			//这里调用business_infservice 的 updateBusiness() 方法,参数比较多
			business_infService.updateBusiness_when_register(base_infService.findByAccount(request.getParameter("regist_account")).getId(),
					request.getParameter("regist_bname"), request.getParameter("regist_addr"), request.getParameter("regist_email"),request.getParameter("regist_type"),
					request.getParameter("regist_bphone"), Float.valueOf(request.getParameter("regist_scorerate")));
			return "/user/user";
		}
		return  "/error";
	}
	
	@RequestMapping("/adduser")
	public String adduser(HttpServletRequest request) {	
		
		
		if(base_infService.put_up_register_user(request.getParameter("regist_account"),request.getParameter("regist_password"))){
			user_infService.updateUser(base_infService.findByAccount(request.getParameter("regist_account")).getId()
					, request.getParameter("regist_uname"),request.getParameter("regist_email")
					, request.getParameter("regist_phone"),Date.valueOf(request.getParameter("regist_birth")),this.getPhotoPath());
			return "/registSuccess";
		}
		return  "/userNameRegistRepeat";
		
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
		return "/regist_user";
	}
	
	@RequestMapping("/checkLogin")
	public String checkLogin(HttpServletRequest request,ModelMap modelMap)
	{
		
		if(base_infService.put_up_login(request.getParameter("login_account")
				, request.getParameter("login_password"), Integer.parseInt(request.getParameter("type"))))
		{
			
			int id=base_infService.findByAccount(request.getParameter("login_account")).getId();
			request.getSession().setAttribute("idlogin", id);
			
			int type=Integer.parseInt(request.getParameter("type"));
			if(type==1) {
				User_inf user_inf=user_infService.findByAdmin(id);
				request.getSession().setAttribute("welcomeName", user_inf.getU_name());
				//request.getSession().setAttribute("u_balance", user_inf.getBalance());
				System.out.println("会员成功登陆");	
				return "user/user";
			}
			else if(type==2)
			{
				Business_inf business_inf=business_infService.findByB_id(id);
				request.getSession().setAttribute("welcomeName", business_inf.getB_name());
				System.out.println("商家成功登陆");
				return "/business/business";
			}
			else if(type==3)
			{
				System.out.println("管理员登陆");
				return "/manager/manager";
			}
		}
		return "/error";
	}
	
	@RequestMapping("/changePwd")
	public String changePwd(HttpServletRequest request)
	{
		Base_inf base_inf = base_infService.findByID((Integer)request.getSession().getAttribute("idlogin"));
		base_inf.setPassword(request.getParameter("update_password"));
		base_infService.updateBase_inf(base_inf);
		return "/user/userpassword_modify";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		return "/login";
	}
}
