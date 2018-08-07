package com.cqu.service;

import java.util.List;

import com.cqu.entity.Base_inf;
import com.cqu.entity.Page;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午9:37:59
 * @version 1.0
 */
public interface Base_infService {
	public void addBase_inf(Base_inf base);
	public void deleteBase_inf(Base_inf base);
	public void updateBase_inf(Base_inf base);
	public List<Base_inf> getALL();
	public Base_inf findByAccount(String account);
	public Page findForPage(int currentPage,int pageSize);
	//判断登录
	public boolean put_up_login(String account,String password,Integer type); 

	//判断注册
	public boolean put_up_register_business(String account,String password);
	public boolean put_up_register_user(String account,String password);
	
	public Base_inf findByID(Integer id);
}
