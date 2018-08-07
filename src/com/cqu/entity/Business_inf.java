package com.cqu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 * @author CHT
 * @date 创建时间：2017年7月11日 下午4:10:20
 * @version 1.0
 */
@Entity
@Table(name = "business_inf")
public class Business_inf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_id", unique = true, nullable = false)
	private Integer b_id;

	@Column(name = "b_name", unique = true, nullable = false, length = 30)
	private String b_name;

	@Column(name = "b_type", length = 20)
	private String b_type;

	@Column(name = "b_add", length = 40)
	private String b_add;

	@Column(name = "b_mail", length = 20)
	private String b_mail;

	@Column(name = "b_tel", length = 15)
	private String b_tel;

	@Column(name = "score_rate", length = 3)
	private float score_rate;

	@Column(name = "question")
	private String question;

	@Column(name = "request")
	private String request;

	@Column(name = "is_register", nullable = false)
	private short is_register;

	// 暂时不用
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "b_id", unique = true, nullable = false, insertable = false, updatable = false)
	private Base_inf base_inf;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "business_inf")
	private Set<Commodity_inf> commodityInfs = new HashSet<Commodity_inf>(0);

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "business_inf")
	private Set<User_score> userScores = new HashSet<User_score>(0);

	// 暂时不用
	public Business_inf() {

	}

	public Business_inf(Integer b_id, String b_name, float score_rate, short isRegister) {
		this.b_id = b_id;
		this.b_name = b_name;
		this.score_rate = score_rate;
		this.is_register = isRegister;
	}

	
	public Business_inf(Integer b_id, String BName, String BType, String BAdd, String BMail, String BTel,
			float scoreRate, String question, String request, short isRegister) {
		this.b_id = b_id;
		this.b_name = BName;
		this.b_type = BType;
		this.b_add = BAdd;
		this.b_mail = BMail;
		this.b_tel = BTel;
		this.score_rate = scoreRate;
		this.question = question;
		this.request = request;
		this.is_register = isRegister;
	}

	public Set<Commodity_inf> getCommodityInfs() {
		return commodityInfs;
	}

	public void setCommodityInfs(Set<Commodity_inf> commodityInfs) {
		this.commodityInfs = commodityInfs;
	}

	public Set<User_score> getUserScores() {
		return userScores;
	}

	public void setUserScores(Set<User_score> userScores) {
		this.userScores = userScores;
	}

	public Base_inf getBase_inf() {
		return base_inf;
	}

	public void setBase_inf(Base_inf base_inf) {
		this.base_inf = base_inf;
	}

	public Integer getB_id() {
		return b_id;
	}

	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_type() {
		return b_type;
	}

	public void setB_type(String b_type) {
		this.b_type = b_type;
	}

	public String getB_add() {
		return b_add;
	}

	public void setB_add(String b_add) {
		this.b_add = b_add;
	}

	public String getB_mail() {
		return b_mail;
	}

	public void setB_mail(String b_mail) {
		this.b_mail = b_mail;
	}

	public String getB_tel() {
		return b_tel;
	}

	public void setB_tel(String b_tel) {
		this.b_tel = b_tel;
	}

	public float getScore_rate() {
		return score_rate;
	}

	public void setScore_rate(float score_rate) {
		this.score_rate = score_rate;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public short getIs_register() {
		return is_register;
	}

	public void setIs_register(short is_register) {
		this.is_register = is_register;
	}
}
