package com.cqu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.dao.User_scoreDAO;
import com.cqu.entity.Page;
import com.cqu.entity.User_score;

/*
 * @author CHT
 * @date 创建时间：2017年7月15日 上午10:43:18
 * @version 1.0
 */

@Service
public class User_scoreServiceImpl implements User_scoreService {

	@Autowired
	private User_scoreDAO user_scoreDAO;

	@Override
	public List<User_score> findByUser(Integer u_id) {

		return user_scoreDAO.findByU_id(u_id);
	}

	@Override
	public List<User_score> findByBusiness(Integer b_id) {

		return user_scoreDAO.findByB_id(b_id);
	}

	@Override
	public void save(User_score user_score) {
		
		user_scoreDAO.save(user_score);
	}

	@Override
	public Page findForPage(int currentPage, int pageSize) {
		Page page = new Page();       
        //总记录数
        int allRow = user_scoreDAO.getAllNum();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<User_score> list = user_scoreDAO.getAllToPage(offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setUser_scores(list);
        return page;
	}


	@Override
	public Page findAllToPage(Integer u_id,int currentPage, int pageSize) {
		Page page = new Page();       
        //总记录数
        int allRow = user_scoreDAO.findByU_id(u_id).size();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<User_score> list = user_scoreDAO.getAllToPageAbout(u_id, offset, pageSize);
 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setUser_scores(list); 
        return page;
	}

	@Override
	public Page findAllB_idToPage(Integer b_id, int currentPage, int pageSize) {
		Page page = new Page();       
        //总记录数
        int allRow = user_scoreDAO.findByU_id(b_id).size();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<User_score> list = user_scoreDAO.getAllToPageAbout(b_id, offset, pageSize);
 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setUser_scores(list); 
        return page;
	}
	
	
	

}
