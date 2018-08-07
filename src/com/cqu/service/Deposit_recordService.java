package com.cqu.service;

import java.util.List;

import com.cqu.entity.Deposit_record;
import com.cqu.entity.Page;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午9:49:11
 * @version 1.0
 */
public interface Deposit_recordService {
	public void addDeposit_record(Deposit_record deposit_record);
	public List<Deposit_record> findByUser(Integer u_id);
	//分页
	public Page findForPage(int currentPage,int pageSize);
	
	public Page findByU_idToPage(int u_id,int currentPage,int pageSize);
}
