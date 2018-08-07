package com.cqu.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cqu.entity.DepositRecordId;
import com.cqu.entity.Deposit_record;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 上午10:41:13
 * @version 1.0
 */

@Repository
public class Deposit_recordDAOImpl implements Deposit_recordDAO {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionfactory;

	@Override
	public void save(Deposit_record deposit_record) {
		sessionfactory.getCurrentSession().save(deposit_record);
	}

	@Override
	public void delete(Deposit_record deposit_record) {
		sessionfactory.getCurrentSession().delete(deposit_record);
	}

	@Override
	public void update(Deposit_record deposit_record) {
		sessionfactory.getCurrentSession().update(deposit_record);
	}

	@Override
	public Deposit_record findByID(DepositRecordId depositRecordId) {
		Deposit_record deposit_record = (Deposit_record)sessionfactory.getCurrentSession().get(Deposit_record.class, depositRecordId);
		return deposit_record;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Deposit_record> getAll() {
		return sessionfactory.getCurrentSession().createCriteria(Deposit_record.class).list();
	}

	@Override
	public int getAllNum() {
		return getAll().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deposit_record> getAllToPage(int offset, int length) {
		return sessionfactory.getCurrentSession().createCriteria(Deposit_record.class).setFirstResult(offset).setMaxResults(length).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deposit_record> findByU_id(Integer u_id) {
		return sessionfactory.getCurrentSession().createCriteria(Deposit_record.class).add(Restrictions.eq("id.u_id",u_id)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Deposit_record> findByU_idToPage(int u_id, int offset, int length) {
		return (List<Deposit_record>)sessionfactory.getCurrentSession().createCriteria(Deposit_record.class).add(Restrictions.eq("id.u_id", u_id)).setFirstResult(offset).setMaxResults(length).list();
	}

	
}
