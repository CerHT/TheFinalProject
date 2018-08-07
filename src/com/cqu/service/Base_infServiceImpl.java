package com.cqu.service;
/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午9:38:44
 * @version 1.0
 */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.dao.Base_infDAO;
import com.cqu.entity.Base_inf;
import com.cqu.entity.Page;

@Service
public class Base_infServiceImpl implements Base_infService {
	@Autowired
	private Base_infDAO base_infDAO;
	
	@Override
	public void addBase_inf(Base_inf base) {
		base_infDAO.save(base);
		
	}

	@Override
	public void deleteBase_inf(Base_inf base) {
		base_infDAO.delete(base);
		
	}

	@Override
	public void updateBase_inf(Base_inf base) {
		base_infDAO.update(base);
		
	}

	@Override
	public List<Base_inf> getALL() {
		return base_infDAO.getAll();
	}

	@Override
	public Base_inf findByAccount(String account) {
		return (Base_inf)base_infDAO.findByAccount(account);
	}

	@Override
	public Page findForPage(int currentPage, int pageSize) {

		Page page = new Page();       
        //总记录数
        int allRow = base_infDAO.getAllNum();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Base_inf> list = base_infDAO.getAllToPage(offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setBase_infs(list); 
        return page;
	}

	@Override
	public boolean put_up_register_business(String account, String password) {

		for(int base_inf_number =0;base_inf_number<base_infDAO.getAll().size();base_inf_number++){
			if(base_infDAO.getAll().get(base_inf_number).getAccount().equals(account))
			{
				return false;
			}
		}
		Base_inf base_inf = new Base_inf(account,password,2);
		base_infDAO.save(base_inf);

		return true;
	}
	
	@Override
	public boolean put_up_register_user(String account, String password) {

		for(int base_inf_number =0;base_inf_number<base_infDAO.getAll().size();base_inf_number++){
			if(base_infDAO.getAll().get(base_inf_number).getAccount().equals(account))
			{
				return false;
			}
		}
		Base_inf base_inf = new Base_inf(account,password,1);
		base_infDAO.save(base_inf);

		return true;
	}

	@Override
	public boolean put_up_login(String account,String password,Integer type){
		if(base_infDAO.findByAccount(account).getPassword().equals(password) &&
				base_infDAO.findByAccount(account).getType() == type)
			return true;
		else
			return false;
	}

	@Override
	public Base_inf findByID(Integer id) {
		return (Base_inf)base_infDAO.findByID(id);
	}

	
}
