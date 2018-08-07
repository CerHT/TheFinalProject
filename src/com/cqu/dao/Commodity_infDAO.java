package com.cqu.dao;

import java.util.List;

import com.cqu.entity.Commodity_inf;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 上午10:13:21
 * @version 1.0
 */
public interface Commodity_infDAO {
	
	public void save(Commodity_inf commodity_inf);
	
	public void delete(Commodity_inf commodity_inf);
	
	public void update(Commodity_inf commodity_inf);
	
	public Commodity_inf findByID(Integer id);
	
	public List<Commodity_inf> getAll();
	
	public int getAllNum();
	
	public List<Commodity_inf> getAllToPage(int offset, int length);
	
	public List<Commodity_inf> findByB_id(Integer b_id);
	
	//模糊查询
	public List<Commodity_inf> getAllAbout(String c_name);
	
	public List<Commodity_inf> getAllAboutByC_name(String c_name,int offset, int length);
	
	public List<Commodity_inf> getAllAboutByB_id(Integer b_id,int offset, int length);
}
