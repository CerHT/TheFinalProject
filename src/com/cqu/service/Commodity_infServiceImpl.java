package com.cqu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.dao.Commodity_infDAO;
import com.cqu.entity.Commodity_inf;
import com.cqu.entity.Page;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午9:48:01
 * @version 1.0
 */

@Service
public class Commodity_infServiceImpl implements Commodity_infService{

	@Autowired
	private Commodity_infDAO commodity_infDAO;

	@Override
	public void addCommodity(Commodity_inf commodity_inf) {

		commodity_infDAO.save(commodity_inf);
	}

	@Override
	public void deleteCommodity(Commodity_inf commodity_inf) {
		
		commodity_infDAO.delete(commodity_inf);
	}

	@Override
	public void updateCommodity(Commodity_inf commodity_inf) {
		commodity_infDAO.update(commodity_inf);
		
	}

	@Override
	public List<Commodity_inf> findByB_id(Integer b_id) {
		
		return commodity_infDAO.findByB_id(b_id);
	}

	@Override
	public List<Commodity_inf> findAllByC_name(String c_name) {
		
		return null;
	}

	@Override
	public Commodity_inf findByC_idByAdmin(Integer c_id) {
		
		return commodity_infDAO.findByID(c_id);
	}

	@Override
	public Page findForPage(int currentPage, int pageSize) {
		
		Page page = new Page();       
        //总记录数
        int allRow = commodity_infDAO.getAllNum();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Commodity_inf> list = commodity_infDAO.getAllToPage(offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setCommodity_infs(list);
        return page;
	}

	@Override
	public Page findByC_nameToPage(String c_name, int currentPage, int pageSize) {
		Page page = new Page();       
        //总记录数
        int allRow = findAllByC_name(c_name).size();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Commodity_inf> list = commodity_infDAO.getAllAboutByC_name(c_name,offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setCommodity_infs(list);
        return page;
	}

	@Override
	public Page findByB_idToPage(Integer b_id, int currentPage, int pageSize) {
		Page page = new Page();       
        //总记录数
        int allRow = commodity_infDAO.findByB_id(b_id).size();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Commodity_inf> list = commodity_infDAO.getAllAboutByB_id(b_id, offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setCommodity_infs(list);
        return page;
	}

}
