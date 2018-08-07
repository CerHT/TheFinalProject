package com.cqu.dao;
/*
 * @author CHT
 * @date 创建时间：2017年7月12日 上午9:59:54
 * @version 1.0
 */

import java.util.List;

import com.cqu.entity.Base_inf;

public interface Base_infDAO {

	public void save(Base_inf base_inf);

	public void delete(Base_inf base_inf);

	public void update(Base_inf base_inf);

	public Base_inf findByID(Integer id);

	public List<Base_inf> getAll();

	public int getAllNum();

	public List<Base_inf> getAllToPage(int offset, int length);

	public Base_inf findByAccount(String account);
}
