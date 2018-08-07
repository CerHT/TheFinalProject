package com.cqu.dao;

import java.util.List;

import com.cqu.entity.DepositRecordId;
import com.cqu.entity.Deposit_record;

/*
 * @author CHT
 * @date 创建时间：2017年7月14日 上午10:30:07
 * @version 1.0
 */
public interface Deposit_recordDAO {

	public void save(Deposit_record deposit_record);

	public void delete(Deposit_record deposit_record);

	public void update(Deposit_record deposit_record);

	public Deposit_record findByID(DepositRecordId depositRecordId);

	public List<Deposit_record> getAll();

	public int getAllNum();

	public List<Deposit_record> getAllToPage(int offset, int length);

	public List<Deposit_record> findByU_id(Integer u_id);

	public List<Deposit_record> findByU_idToPage(int u_id, int offset, int length);
}
