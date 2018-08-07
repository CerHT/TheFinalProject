package com.cqu.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cqu.entity.Base_inf;


/*
 * @author CHT
 * @date 创建时间：2017年7月12日 下午3:14:07
 * @version 1.0
 */

@Repository
public class Base_infDAOImpl implements Base_infDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionfactory;

	@Override
	public void save(Base_inf base_inf) {
		sessionfactory.getCurrentSession().save(base_inf);

	}

	@Override
	public void delete(Base_inf base_inf) {
		sessionfactory.getCurrentSession().delete(base_inf);

	}

	@Override
	public void update(Base_inf base_inf) {
		sessionfactory.getCurrentSession().update(base_inf);
		
	}

	@Override
	public Base_inf findByID(Integer id) {
		Base_inf base_inf = (Base_inf) sessionfactory.getCurrentSession().get(Base_inf.class, id);
		return base_inf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Base_inf> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(Base_inf.class).list();
	}

	@Override
	public int getAllNum() {
		return getAll().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Base_inf findByAccount(String account) {
		
		List<Base_inf> list = (List<Base_inf>)sessionfactory.getCurrentSession().createCriteria(Base_inf.class)
				.add(Restrictions.eq("account", account)).list();
		 Base_inf base_inf=list.get(0);
		return base_inf;
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 分页查询
	 * 
	 * @see com.cqu.dao.Base_infDAO#getAllToPage(int, int)
	 * @param offset
	 *            开始记录
	 * @param length
	 *            一次查询几条记录
	 * @return 返回记录的集合
	 */
	public List<Base_inf> getAllToPage(int offset, int length) {
		return sessionfactory.getCurrentSession().createCriteria(Base_inf.class).setFirstResult(offset)
				.setMaxResults(length).list();
	}

	//
}
