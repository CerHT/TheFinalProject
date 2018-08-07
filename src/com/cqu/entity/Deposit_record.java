package com.cqu.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

/*
 * @author CHT
 * @date 创建时间：2017年7月11日 下午5:11:21
 * @version 1.0
 */

@Entity
@Table(name = "deposit_record")
public class Deposit_record {
	private DepositRecordId id;
	private User_inf user_inf;
	private float money;

	public Deposit_record() {

	}

	public Deposit_record(DepositRecordId id, float money) {
		this.id = id;
		this.money = money;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "time", column = @Column(name = "time", nullable = false, length = 50)),
			@AttributeOverride(name = "u_id", column = @Column(name = "u_id", nullable = false)) })
	public DepositRecordId getId() {
		return id;
	}

	public void setId(DepositRecordId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "u_id", nullable = false, insertable = false, updatable = false)
	public User_inf getUser_inf() {
		return user_inf;
	}

	public void setUser_inf(User_inf user_inf) {
		this.user_inf = user_inf;
	}

	@Column(name = "money", nullable = false, precision = 12)
	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

}
