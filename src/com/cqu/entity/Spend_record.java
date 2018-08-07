package com.cqu.entity;
/*
 * @author CHT
 * @date 创建时间：2017年7月11日 下午5:12:48
 * @version 1.0
 */

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "spend_record")
public class Spend_record {

	private SpendRecordId id;
	private Commodity_inf commodity_inf;
	private float money;
	private String recommend;
	private short is_use_score;
	private short is_use_cash;
	private float cash;
	private String business_request;
	private Integer used_score_once;
	private Integer commoditynumber;
	private float finalpay;

	private User_inf user_inf;

	public Spend_record() {

	}

	public Spend_record(SpendRecordId id, Commodity_inf commodityInf, float money, short isUseScore, short isUseCash,
			float cash, Integer used_score_once, Integer commodityNum, float finalpay) {
		this.id = id;
		this.commodity_inf = commodityInf;
		this.money = money;
		this.is_use_score = isUseScore;
		this.is_use_cash = isUseCash;
		this.cash = cash;
		this.used_score_once=used_score_once;
		this.commoditynumber=commodityNum;
		this.finalpay=finalpay;
	}

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "time", column = @Column(name = "time", nullable = false)),
			@AttributeOverride(name = "u_id", column = @Column(name = "u_id", nullable = false)) })
	public SpendRecordId getId() {
		return id;
	}

	public void setId(SpendRecordId id) {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_id", nullable = false)
	public Commodity_inf getCommodity_inf() {
		return commodity_inf;
	}

	public void setCommodity_inf(Commodity_inf commodity_inf) {
		this.commodity_inf = commodity_inf;
	}

	@Column(name = "money", nullable = false, precision = 10)
	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	@Column(name = "recommend")
	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	@Column(name = "is_use_score")
	public short getIs_use_score() {
		return is_use_score;
	}

	public void setIs_use_score(short is_use_score) {
		this.is_use_score = is_use_score;
	}

	@Column(name = "is_use_cash")
	public short getIs_use_cash() {
		return is_use_cash;
	}

	public void setIs_use_cash(short is_use_cash) {
		this.is_use_cash = is_use_cash;
	}

	@Column(name = "cash", precision = 12)
	public float getCash() {
		return cash;
	}

	public void setCash(float cash) {
		this.cash = cash;
	}

	@Column(name = "business_request")
	public String getBusiness_request() {
		return business_request;
	}

	public void setBusiness_request(String business_request) {
		this.business_request = business_request;
	}

	@Column(name = "used_score_once")
	public Integer getUsed_score_once() {
		return used_score_once;
	}

	public void setUsed_score_once(Integer used_score_once) {
		this.used_score_once = used_score_once;
	}

	@Column(name = "commoditynumber")
	public Integer getCommoditynumber() {
		return commoditynumber;
	}

	public void setCommoditynumber(Integer commoditynumber) {
		this.commoditynumber = commoditynumber;
	}

	@Column(name = "finalpay")
	public float getFinalpay() {
		return finalpay;
	}

	public void setFinalpay(float finalpay) {
		this.finalpay = finalpay;
	}

}
