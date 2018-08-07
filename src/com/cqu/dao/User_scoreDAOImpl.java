package com.cqu.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cqu.entity.UserScoreId;
import com.cqu.entity.User_score;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 下午9:15:47
 * @version 1.0
 */

@Repository
public class User_scoreDAOImpl implements User_scoreDAO {

	@Resource(name="sessionFactory")
	private SessionFactory sessionfactory;
	
	@Override
	public void save(User_score user_score) {
		sessionfactory.getCurrentSession().save(user_score);
	}

	@Override
	public void delete(User_score user_score) {
		sessionfactory.getCurrentSession().delete(user_score);
	}

	@Override
	public void update(User_score user_score) {
		sessionfactory.getCurrentSession().update(user_score);
	}

	@Override
	public User_score findByID(UserScoreId userScoreId) {
		return (User_score)sessionfactory.getCurrentSession().get(User_score.class, userScoreId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_score> getAll() {
		return (List<User_score>)sessionfactory.getCurrentSession().createCriteria(User_score.class).list();
	}

	@Override
	public int getAllNum() {
		return getAll().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_score> getAllToPage(int offset, int length) {
		return (List<User_score>)sessionfactory.getCurrentSession().createCriteria(User_score.class).setFirstResult(offset).setMaxResults(length).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_score> findByB_id(Integer b_id) {
		return (List<User_score>)sessionfactory.getCurrentSession().createCriteria(User_score.class).add(Restrictions.eq("b_id", b_id)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_score> findByU_id(Integer u_id) {
		return (List<User_score>)sessionfactory.getCurrentSession().createCriteria(User_score.class).add(Restrictions.eq("id.u_id", u_id)).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User_score> getAllToPageAbout(Integer u_id, int offset, int length) {
		List<User_score> list = (List<User_score>)sessionfactory.getCurrentSession()
				.createCriteria(User_score.class)
				.add(Restrictions.eq("id.u_id",u_id))
				.setFirstResult(offset).setMaxResults(length).list();
		return list;
	}

	@Override
	public List<User_score> findAllByB_idToPage(Integer b_id, int offset, int length) {
		@SuppressWarnings("unchecked")
		List<User_score> list = (List<User_score>)sessionfactory.getCurrentSession()
				.createCriteria(User_score.class)
				.add(Restrictions.eq("id.b_id",b_id))
				.setFirstResult(offset).setMaxResults(length).list();
		return list;
	}

}
