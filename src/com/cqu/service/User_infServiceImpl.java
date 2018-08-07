package com.cqu.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cqu.dao.User_infDAO;
import com.cqu.entity.Page;
import com.cqu.entity.User_inf;
@Service
public class User_infServiceImpl implements User_infService {

	@Autowired
	private User_infDAO user_infDAO;
	
	@Override
	public void deleteUser_inf(User_inf user_inf) {
		
		user_infDAO.delete(user_inf);
	}

	@Override
	public void updateUser_inf(User_inf user_inf) {
		
		user_infDAO.update(user_inf);
	}

	@Override
	public Page findForPage(int currentPage, int pageSize) {
		Page page = new Page();       
        //总记录数
        int allRow = user_infDAO.getAllNum();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<User_inf> list = user_infDAO.getAllToPage(offset, pageSize); 
        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setUser_infs(list);
        return page;
	}

	@Override
	public int ServicegetCount() {

		return user_infDAO.getAllNum();
	}

	@Override
	public List<User_inf> findAllByAdmin() {

		return user_infDAO.getAll();
	}

	@Override
	public User_inf findByAdmin(Integer u_id) {

		return user_infDAO.findByU_id(u_id);
	}

	@Override
	public void updateUser(Integer u_id, String u_name, String u_mail, String u_tel, Date u_birth,String photoPath) {
		
		User_inf user_inf = new User_inf();
		user_inf.setU_id(u_id);
		user_inf.setU_name(u_name);
		user_inf.setU_birth(u_birth);
		user_inf.setU_mail(u_mail);
		user_inf.setU_tel(u_tel);
		user_inf.setU_photo(photoPath);
		user_infDAO.update(user_inf);
	}

}
