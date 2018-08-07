package com.cqu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.dao.Commodity_infDAO;
import com.cqu.dao.Spend_recordDAO;
import com.cqu.entity.Page;
import com.cqu.entity.Spend_record;

@Service
public class Spend_recordServiceImpl implements Spend_recordService {

	@Autowired
	private Spend_recordDAO spend_recordDAO;

	@Autowired
	private Commodity_infDAO commodity_infDAO;

	@Override
	public void addSpend_record(Spend_record spend_record) {

		spend_recordDAO.save(spend_record);
	}

	@Override
	public List<Spend_record> findByUser(Integer u_id) {

		return spend_recordDAO.findByU_id(u_id);
	}

	@Override
	public List<Spend_record> findByC_id(Integer c_id) {

		return spend_recordDAO.findByC_id(c_id);
	}

	@Override
	public Page findForPage(int currentPage, int pageSize) {
		Page page = new Page();
		// 总记录数
		int allRow = spend_recordDAO.getAllNum();
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Spend_record> list = spend_recordDAO.getAllToPage(offset, pageSize);
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setSpend_records(list);
		return page;
	}

	@Override
	public List<Spend_record> findByBusiness(Integer b_id) {
		List<Integer> list = new ArrayList<Integer>();
		List<Spend_record> consumes = new ArrayList<Spend_record>();
		for (int i = 0; i < commodity_infDAO.findByB_id(b_id).size(); i++) {
			list.add(commodity_infDAO.findByB_id(b_id).get(i).getC_id());
		}
		for (int listcount = 0; listcount < list.size(); listcount++) {
			consumes.addAll(spend_recordDAO.findByC_id(list.get(listcount)));
		}

		return consumes;
	}

	@Override
	public Page findAllAboutToPage(Integer u_id, int currentPage, int pageSize) {
		Page page = new Page();
		// 当前页开始记录
		int offset = page.countOffset(currentPage, pageSize);
		// 分页查询结果集
		List<Spend_record> list = spend_recordDAO.getAllToPageAbout(u_id, offset, pageSize);
		// 总记录数
		int allRow = spend_recordDAO.findByU_id(u_id).size();
		page.setPageNo(currentPage);
		page.setPageSize(pageSize);
		page.setTotalRecords(allRow);
		page.setSpend_records(list);
		return page;
	}
}
