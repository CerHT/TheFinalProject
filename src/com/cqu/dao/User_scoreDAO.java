package com.cqu.dao;

import java.util.List;

import com.cqu.entity.UserScoreId;
import com.cqu.entity.User_score;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午8:45:36
 * @version 1.0
 */
public interface User_scoreDAO {

	public void save(User_score user_score);

	public void delete(User_score user_score);

	public void update(User_score user_score);

	public User_score findByID(UserScoreId userScoreId);

	public List<User_score> getAll();

	public int getAllNum();

	public List<User_score> getAllToPage(int offset, int length);
	
	public List<User_score> findByB_id(Integer b_id);
	
	public List<User_score> findByU_id(Integer u_id);
	
	public List<User_score> getAllToPageAbout(Integer u_id,int offset, int length);
	
	public List<User_score> findAllByB_idToPage(Integer b_id,int offset,int length);
}
