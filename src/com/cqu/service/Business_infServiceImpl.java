package com.cqu.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.dao.Business_infDAO;
import com.cqu.entity.Business_inf;
import com.cqu.entity.Page;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午9:40:09
 * @version 1.0
 */

@Service()
public class Business_infServiceImpl implements Business_infService {
	@Autowired
	private Business_infDAO business_infDAO;

	@Override
	public void save(Business_inf business_inf) {
		business_infDAO.save(business_inf);
		
	}

	@Override
	public void delete(Business_inf business_inf) {
		
		business_infDAO.delete(business_inf);
	}

	@Override
	public Business_inf get(Integer b_id) {

		return business_infDAO.findByID(b_id);
	}

	@Override
	public List<Business_inf> getAll() {

		return business_infDAO.getAll();
	}

	@Override
	public Business_inf findByB_name(String b_name) {

		return business_infDAO.findByB_name(b_name);
	}

	@Override
	public Page getAllToPage(int currentPage, int pageSize) {

		Page page = new Page();       
        //总记录数
        int allRow = business_infDAO.getAllNum();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Business_inf> list = business_infDAO.getAllToPage(offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setBusiness_infs(list);
        return page;
	}

	@Override
	public List<Business_inf> findAllByB_nameAbout(String b_name) {

		return business_infDAO.getAllAbout(b_name);
	}

//	@Override
//	public void updateBusiness(Integer b_id, String b_name, String b_add, String b_mail,String b_type, String b_tel, float score_rate) {
//		
//		Business_inf business_inf = new Business_inf(b_id,b_name,score_rate,(short)1);
//		business_inf.setB_mail(b_mail);
//		business_inf.setB_add(b_add);
//		business_inf.setB_tel(b_tel);
//		business_inf.setB_type(b_type);
//		business_inf.setIs_register((short)1);
//		business_infDAO.update(business_inf);
//	}

	@Override
	public void updateBusiness_when_register(Integer b_id, String b_name, String b_add, String b_mail, String b_type,
			String b_tel, float score_rate) {
		Business_inf business_inf = new Business_inf(b_id,b_name,score_rate,(short)1);
		business_inf.setB_mail(b_mail);
		business_inf.setB_add(b_add);
		business_inf.setB_tel(b_tel);
		business_inf.setB_type(b_type);
		business_inf.setIs_register((short)0);
		business_infDAO.update(business_inf);
		
	}

	@Override
	public List<Business_inf> findAll_not_register_business() {
		List<Business_inf> list = business_infDAO.getAll();
		List<Business_inf> Business_infs = new ArrayList<Business_inf>();
		for(int number=0;number<list.size();number++){
			if(list.get(number).getIs_register() == (short)0){
				Business_infs.add(list.get(number));
			}
		}
		return Business_infs;
	}

	@Override
	public List<Business_inf> findAll_is_register_business() {
		List<Business_inf> list = business_infDAO.getAll();
		List<Business_inf> Business_infs = new ArrayList<Business_inf>();
		for(int number=0;number<list.size();number++){
			if(list.get(number).getIs_register() != (short)0){
				Business_infs.add(list.get(number));
			}
		}
		return Business_infs;
	}

	
	@Override
	public Page findAll_not_registerToPage(int currentPage, int pageSize) {
		Page page = new Page();       
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Business_inf> list = business_infDAO.getAll_not_register(offset, pageSize); 
        //总记录数
        int allRow = findAll_not_register_business().size();
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setBusiness_infs(list);
        return page;
	}

	@Override
	public Page findAll_registerToPage(int currentPage, int pageSize) {
		Page page = new Page();       
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Business_inf> list = business_infDAO.getAll_register(offset, pageSize); 
        //总记录数
        int allRow = findAll_is_register_business().size();
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setBusiness_infs(list);
        return page;
	}

	@Override
	public Page findAllByB_nameAboutToPage(String b_name, int currentPage, int pageSize) {
		Page page = new Page();       
        //总记录数
        int allRow = findAllByB_nameAbout(b_name).size();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Business_inf> list = business_infDAO.getAllAboutToPage(b_name,offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setBusiness_infs(list);
        return page;
	}

	@Override
	public boolean updateBusiness_is_register(Integer u_id) {
		
		if(business_infDAO.update_Passregister(business_infDAO.findByID(u_id)))
			return true;
		return false;
	}

	@Override
	public void update(Business_inf business_inf) {

		business_infDAO.update(business_inf);
	}

	@Override
	public Business_inf findByB_id(Integer b_id) {
		
		return business_infDAO.findByID(b_id);
	}
	
	
	
}
