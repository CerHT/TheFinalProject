package com.cqu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cqu.entity.Commodity_inf;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 上午10:23:34
 * @version 1.0
 */

@Repository
public class Commodity_infDAOImpl implements Commodity_infDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionfactory;

	@Override
	public void save(Commodity_inf commodity_inf) {
		sessionfactory.getCurrentSession().save(commodity_inf);
	}

	@Override
	public void delete(Commodity_inf commodity_inf) {
		sessionfactory.getCurrentSession().delete(commodity_inf);
	}

	@Override
	public void update(Commodity_inf commodity_inf) {
		sessionfactory.getCurrentSession().update(commodity_inf);
	}

	@Override
	public Commodity_inf findByID(Integer id) {
		Commodity_inf commodity_inf=(Commodity_inf)sessionfactory.getCurrentSession().get(Commodity_inf.class, id);
		return commodity_inf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity_inf> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(Commodity_inf.class).list();
	}

	@Override
	public int getAllNum() {
		return getAll().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity_inf> getAllToPage(int offset, int length) {
		return sessionfactory.getCurrentSession().createCriteria(Commodity_inf.class).setFirstResult(offset).setMaxResults(length).list();
	}

	@Override
	public List<Commodity_inf> findByB_id(Integer b_id) {
		
		List<Commodity_inf> list = new ArrayList<Commodity_inf>();
		for(int i = 0;i<getAll().size();i++){
			if(getAll().get(i).getBusiness_inf().getB_id() == b_id){
				list.add(getAll().get(i));
			}
		}
		return list;
		//return sessionfactory.getCurrentSession().createCriteria(Commodity_inf.class).add(Restrictions.eq("b_id", b_id)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity_inf> getAllAbout(String c_name ) {
		
		return (List<Commodity_inf>)sessionfactory.getCurrentSession()
				.createCriteria(Commodity_inf.class).add(Restrictions.like("c_name", c_name, MatchMode.ANYWHERE)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity_inf> getAllAboutByC_name(String c_name,int offset, int length) {
		return (List<Commodity_inf>)sessionfactory.getCurrentSession()
				.createCriteria(Commodity_inf.class).add(Restrictions.like("c_name", c_name, MatchMode.ANYWHERE)).setFirstResult(offset).setMaxResults(length).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commodity_inf> getAllAboutByB_id(Integer b_id, int offset, int length) {
		return (List<Commodity_inf>)sessionfactory.getCurrentSession()
				.createCriteria(Commodity_inf.class).add(Restrictions.eq("business_inf.b_id", b_id)).setFirstResult(offset).setMaxResults(length).list();

	}
}
