package com.cqu.dao;

import java.util.List;

import com.cqu.entity.User_inf;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午3:17:07
 * @version 1.0
 */
public interface User_infDAO {

	public void save(User_inf user_inf);

	public void delete(User_inf user_inf);

	public void update(User_inf user_inf);

	public User_inf findByU_id(Integer u_id);

	public List<User_inf> getAll();

	public User_inf findByU_name(String u_name);

	public int getAllNum();

	public List<User_inf> getAllToPage(int offset, int length);
	
	
}
