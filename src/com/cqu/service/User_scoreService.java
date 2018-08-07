package com.cqu.service;

import java.util.List;

import com.cqu.entity.Page;
import com.cqu.entity.User_score;

/*
 * @author CHT
 * @date 创建时间：2017年7月15日 上午10:40:53
 * @version 1.0
 */
public interface User_scoreService {
	public List<User_score> findByUser(Integer u_id);
	public List<User_score> findByBusiness(Integer b_id);
	
	public void save(User_score user_score);
	
	//分页查询
	public Page findForPage(int currentPage,int pageSize);
	public Page findAllToPage(Integer u_id,int currentPage,int pageSize);
	
	public Page findAllB_idToPage(Integer b_id,int currentPage,int pageSize);
}
