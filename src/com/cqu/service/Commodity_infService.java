package com.cqu.service;

import java.util.List;

import com.cqu.entity.Commodity_inf;
import com.cqu.entity.Page;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午9:47:44
 * @version 1.0
 */
//还需要有通过name来查找商品吗
public interface Commodity_infService {
	public void addCommodity(Commodity_inf commodity_inf);
	public void deleteCommodity(Commodity_inf commodity_inf);
	public void updateCommodity(Commodity_inf commodity_inf);
	
	public List<Commodity_inf> findByB_id(Integer b_id);
	public Commodity_inf findByC_idByAdmin(Integer c_id);
	//模糊查询
	public List<Commodity_inf> findAllByC_name(String c_name);
	//模糊查询（分页）
	public Page findByC_nameToPage(String c_name,int currentPage,int pageSize);
	//分页查询
	public Page findForPage(int currentPage,int pageSize);
	//普通查询（分页）
	public Page findByB_idToPage(Integer b_id,int currentPage,int pageSize);


	
}
