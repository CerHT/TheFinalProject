package com.cqu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.dao.Deposit_recordDAO;
import com.cqu.entity.Deposit_record;
import com.cqu.entity.Page;

@Service
public class Deposit_recordServiceImpl implements Deposit_recordService {

	@Autowired
	private Deposit_recordDAO deposit_recordDAO;
	
	@Override
	public void addDeposit_record(Deposit_record deposit_record) {

		deposit_recordDAO.save(deposit_record);

	}

	@Override
	public List<Deposit_record> findByUser(Integer u_id) {
		return deposit_recordDAO.findByU_id(u_id);
	}

	@Override
	public Page findForPage(int currentPage, int pageSize) {
		Page page = new Page();       
        //总记录数
        int allRow = deposit_recordDAO.getAllNum();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Deposit_record> list = deposit_recordDAO.getAllToPage(offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setDeposit_records(list);
        return page;
	}

	@Override
	public Page findByU_idToPage(int u_id, int currentPage, int pageSize) {
		Page page = new Page();       
        //总记录数
        int allRow = deposit_recordDAO.findByU_id(u_id).size();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Deposit_record> list = deposit_recordDAO.findByU_idToPage(u_id, offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setDeposit_records(list);
        return page;
	}

}
