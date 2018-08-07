package com.cqu.dao;

import java.util.List;

import com.cqu.entity.SpendRecordId;
import com.cqu.entity.Spend_record;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 上午11:37:59
 * @version 1.0
 */
public interface Spend_recordDAO {

	public void save(Spend_record spend_record);
	
	public void delete(Spend_record spend_record);
	
	public void update(Spend_record spend_record);
	
	public Spend_record findByID(SpendRecordId spendRecordId);
	
	public List<Spend_record> getAll();
	
	public int getAllNum();
	
	public List<Spend_record> getAllToPage(int offset,int length);
	
	public List<Spend_record> findByC_id(Integer c_id);
	
	public List<Spend_record> findByU_id(Integer u_id);
	
	public List<Spend_record> getAllToPageAbout(Integer u_id,int offset,int length);
	
}
