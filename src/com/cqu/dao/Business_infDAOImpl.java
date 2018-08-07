package com.cqu.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cqu.entity.Business_inf;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 上午9:29:31
 * @version 1.0
 */

@Repository
public class Business_infDAOImpl implements Business_infDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionfactory;

	@Override
	public void save(Business_inf business_inf) {
		sessionfactory.getCurrentSession().save(business_inf);
	}

	@Override
	public void delete(Business_inf business_inf) {
		sessionfactory.getCurrentSession().delete(business_inf);

	}

	@Override
	public void update(Business_inf business_inf) {
		sessionfactory.getCurrentSession().update(business_inf);
	}

	@Override
	public Business_inf findByID(Integer id) {
		Business_inf business_inf = (Business_inf) sessionfactory.getCurrentSession().get(Business_inf.class, id);
		return business_inf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Business_inf> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(Business_inf.class).list();
	}

	@Override
	public int getAllNum() {
		return getAll().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Business_inf findByB_name(String name) {
		List<Business_inf> business_infs = (List<Business_inf>) sessionfactory.getCurrentSession().createCriteria(Business_inf.class)
				.add(Restrictions.eq("b_name", name)).list();
		Business_inf business_inf = business_infs.get(0);
		return business_inf;
	}

	/**
	 * 分页查询
	 * @see com.cqu.dao.Business_infDAO#getAllToPage(int, int)
	 * @author 陈瀚涛
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Business_inf> getAllToPage(int offset, int length) {
		return sessionfactory.getCurrentSession().createCriteria(Business_inf.class).setFirstResult(offset).setMaxResults(length).list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Business_inf> getAllAbout(String b_name) {
		List<Business_inf> list = (List<Business_inf>)sessionfactory.getCurrentSession()
				.createCriteria(Business_inf.class)
				.add(Restrictions.like("b_name",b_name, MatchMode.ANYWHERE)).list();
		return list;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Business_inf> getAll_not_register(int offset, int length) {
		return sessionfactory.getCurrentSession().createCriteria(Business_inf.class)
				.add(Restrictions.eq("is_register", (short)0))
				.setFirstResult(offset).setMaxResults(length).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Business_inf> getAll_register(int offset, int length) {
		return sessionfactory.getCurrentSession().createCriteria(Business_inf.class)
				.add(Restrictions.eq("is_register", (short)1))
				.setFirstResult(offset).setMaxResults(length).list();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Business_inf> getAllAboutToPage(String b_name, int offset, int length) {

		List<Business_inf> list = (List<Business_inf>)sessionfactory.getCurrentSession()
				.createCriteria(Business_inf.class)
				.add(Restrictions.like("b_name",b_name, MatchMode.ANYWHERE))
				.setFirstResult(offset).setMaxResults(length).list();
		return list;
	}

	@Override
	public boolean update_Passregister(Business_inf business_inf) {
		business_inf.setIs_register((short)1);
		return true;
	}
}
