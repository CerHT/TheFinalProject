package com.cqu.service;

import java.sql.Date;
import java.util.List;

import com.cqu.entity.Page;
import com.cqu.entity.User_inf;

public interface User_infService {
	public void deleteUser_inf(User_inf user_inf);
	public void updateUser_inf(User_inf user_inf);
	public void updateUser(Integer u_id,String u_name,String mail,String tel,Date birth,String photoPath);
	//分页查询
	public Page findForPage(int currentPage,int pageSize);
	public int ServicegetCount();
	
	public List<User_inf> findAllByAdmin();
	public User_inf findByAdmin(Integer u_id);
	
}
