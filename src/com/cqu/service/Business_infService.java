package com.cqu.service;

import java.util.List;

import com.cqu.entity.Business_inf;
import com.cqu.entity.Page;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午9:39:37
 * @version 1.0
 */
public interface Business_infService {
	public void save(Business_inf business_inf);
	public void delete(Business_inf business_inf);
	public void update(Business_inf business_inf);
	//通过 account 来查找 id,（如有需要的话）
	//public void updateBusiness(Integer b_id,String b_name,String b_add,String b_mail,String b_type,String b_tel,float score_rate);
	//注册时用(未审核状态)
	public void updateBusiness_when_register(Integer b_id,String b_name,String b_add,String b_mail,String b_type,String b_tel,float score_rate);
	//通过审核
	public boolean updateBusiness_is_register(Integer u_id);
	
	public Business_inf get(Integer b_id);
	public List<Business_inf> getAll();
	public Business_inf findByB_name(String b_name);	
	public Business_inf findByB_id(Integer b_id);
	public Page getAllToPage(int currentPage, int pageSize);
	
	//模糊查询
	public List<Business_inf> findAllByB_nameAbout(String b_name);
	//模糊查询（分页）
	public Page findAllByB_nameAboutToPage(String b_name,int currentPage, int pageSize);
	//找出所有未审核的 商家
	public List<Business_inf> findAll_not_register_business();
	//找出所有审核过的商家
	public List<Business_inf> findAll_is_register_business();
	//管理员查看未审核的商家(分页)
	public Page findAll_not_registerToPage(int currentPage, int pageSize);
	//管理员查看审核的商家(分页)
	public Page findAll_registerToPage(int currentPage, int pageSize);
}
