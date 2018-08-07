package com.cqu.dao;

import java.util.List;

import com.cqu.entity.Business_inf;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 上午9:16:41
 * @version 1.0
 */
public interface Business_infDAO {

	public void save(Business_inf business_inf);

	public void delete(Business_inf business_inf);

	public void update(Business_inf business_inf);
	
	public boolean update_Passregister(Business_inf business_inf);

	public Business_inf findByID(Integer id);

	public List<Business_inf> getAll();

	public int getAllNum();

	public List<Business_inf> getAllToPage(int offset, int length);

	public Business_inf findByB_name(String name);
	
	//未注册商家(分页)
	public List<Business_inf> getAll_not_register(int offset, int length);
	//注册商家(分页)
	public List<Business_inf> getAll_register(int offset, int length);
	//模糊查询
	public List<Business_inf> getAllAbout(String b_name);
	//模糊查询（分页）
	public List<Business_inf> getAllAboutToPage(String b_name,int offset, int length);
}
