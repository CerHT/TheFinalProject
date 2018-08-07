package com.cqu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cqu.entity.SpendRecordId;
import com.cqu.entity.Spend_record;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午2:38:22
 * @version 1.0
 */

@Repository
public class Spend_recordDAOImpl implements Spend_recordDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionfactory;

	@Override
	public void save(Spend_record spend_record) {
		sessionfactory.getCurrentSession().save(spend_record);
	}

	@Override
	public void delete(Spend_record spend_record) {
		sessionfactory.getCurrentSession().delete(spend_record);
	}

	@Override
	public void update(Spend_record spend_record) {
		sessionfactory.getCurrentSession().update(spend_record);
	}

	@Override
	public Spend_record findByID(SpendRecordId spendRecordId) {
		return (Spend_record) sessionfactory.getCurrentSession().get(Spend_record.class, spendRecordId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Spend_record> getAll() {
		return (List<Spend_record>) sessionfactory.getCurrentSession().createCriteria(Spend_record.class).list();
	}

	@Override
	public int getAllNum() {
		return getAll().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Spend_record> getAllToPage(int offset, int length) {
		return (List<Spend_record>) sessionfactory.getCurrentSession().createCriteria(Spend_record.class)
				.setFirstResult(offset).setMaxResults(length).list();
	}

	@Override
	public List<Spend_record> findByC_id(Integer c_id) {
		List<Spend_record> list = new ArrayList<Spend_record>();
		for (int i = 0; i < getAll().size(); i++) {
			if (getAll().get(i).getCommodity_inf().getC_id() == c_id) {
				list.add(getAll().get(i));
				System.out.println(getAll().get(i).getMoney());
			}
		}
		return list;
		// return
		// (List<Spend_record>)sessionfactory.getCurrentSession().createCriteria(Spend_record.class).add(Restrictions.eq("c_id",
		// c_id)).list();
	}

	@Override
	public List<Spend_record> findByU_id(Integer u_id) {
		List<Spend_record> list = new ArrayList<Spend_record>();
		for (int i = 0; i < getAll().size(); i++) {
			if (getAll().get(i).getId().getU_id() == u_id) {
				list.add(getAll().get(i));
				System.out.println(getAll().get(i).getMoney());
			}
		}
		return list;
		// return (List<Spend_record>)sessionfactory.getCurrentSession()
		// .createCriteria(Spend_record.class)
		// .add(Restrictions.eq("u_id", u_id)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Spend_record> getAllToPageAbout(Integer u_id, int offset, int length) {

		List<Spend_record> list = (List<Spend_record>) sessionfactory.getCurrentSession()
				.createCriteria(Spend_record.class).add(Restrictions.eq("id.u_id", u_id))
				.setFirstResult(offset).setMaxResults(length).list();
		return list;
	}

}
