package com.cqu.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cqu.entity.User_inf;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午3:36:11
 * @version 1.0
 */

@Repository
public class User_infDAOImpl implements User_infDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionfactory;

	@Override
	public void save(User_inf user_inf) {
		sessionfactory.getCurrentSession().save(user_inf);
	}

	@Override
	public void delete(User_inf user_inf) {
		sessionfactory.getCurrentSession().delete(user_inf);
	}

	@Override
	public void update(User_inf user_inf) {
		sessionfactory.getCurrentSession().update(user_inf);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User_inf findByU_id(Integer u_id) {
		List<User_inf> list=(List<User_inf>)sessionfactory.getCurrentSession().createCriteria(User_inf.class).add(Restrictions.eq("u_id", u_id)).list();
		User_inf user_inf=list.get(0);
		return user_inf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_inf> getAll() {
		return (List<User_inf>)sessionfactory.getCurrentSession().createCriteria(User_inf.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User_inf findByU_name(String u_name) {
		return ((List<User_inf>)sessionfactory.getCurrentSession().createCriteria(User_inf.class).add(Restrictions.eq("u_name", u_name)).list()).get(0);
	}

	@Override
	public int getAllNum() {
		return getAll().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_inf> getAllToPage(int offset, int length) {
		return (List<User_inf>)sessionfactory.getCurrentSession().createCriteria(User_inf.class).setFirstResult(offset).setMaxResults(length).list();
	}

}
