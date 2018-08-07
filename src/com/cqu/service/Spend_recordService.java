package com.cqu.service;

import java.util.List;

import com.cqu.entity.Page;
import com.cqu.entity.Spend_record;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午9:50:13
 * @version 1.0
 */
public interface Spend_recordService {

	public void addSpend_record(Spend_record spend_record);

	public List<Spend_record> findByUser(Integer u_id);

	public List<Spend_record> findByC_id(Integer c_id);

	public List<Spend_record> findByBusiness(Integer b_id);

	// 分页查询
	public Page findForPage(int currentPage, int pageSize);

	public Page findAllAboutToPage(Integer u_id, int currentPage, int pageSize);
}
