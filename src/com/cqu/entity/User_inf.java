package com.cqu.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * @author CHT
 * @date 创建时间：2017年7月11日 下午5:13:00
 * @version 1.0
 */

@Entity
@Table(name = "user_inf")
public class User_inf {

	private Integer u_id;
	private float balance;
	private String u_name;
	private String u_mail;
	private String u_tel;
	private Date u_birth;
	private String u_photo;

	private Base_inf base_inf;
	private Set<Deposit_record> deposit_records = new HashSet<Deposit_record>(0);
	private Set<User_score> user_scores = new HashSet<User_score>(0);
	private Set<Spend_record> spend_records = new HashSet<Spend_record>(0);

	public User_inf() {

	}

	public User_inf(Integer u_id, String UName) {
		this.u_id = u_id;
		this.u_name = UName;
	}

	public User_inf(Integer u_id, Float balance, String UName, String UMail, String UTel, Date UBirth,
			String photoPath) {
		this.u_id = u_id;
		this.balance = balance;
		this.u_name = UName;
		this.u_mail = UMail;
		this.u_tel = UTel;
		this.u_birth = UBirth;
		this.u_photo = photoPath;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "u_id", unique = true, nullable = false)
	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "u_id", unique = true, nullable = false, insertable = false, updatable = false)
	public Base_inf getBase_inf() {
		return base_inf;
	}

	public void setBase_inf(Base_inf base_inf) {
		this.base_inf = base_inf;
	}

	@Column(name = "balance", precision = 12)
	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Column(name = "u_name", unique = true, nullable = false, length = 20)
	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	@Column(name = "u_mail", length = 20)
	public String getU_mail() {
		return u_mail;
	}

	public void setU_mail(String u_mail) {
		this.u_mail = u_mail;
	}

	@Column(name = "u_tel", length = 20)
	public String getU_tel() {
		return u_tel;
	}

	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "u_birth", length = 10)
	public Date getU_birth() {
		return u_birth;
	}

	public void setU_birth(Date u_birth) {
		this.u_birth = u_birth;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user_inf")
	public Set<Deposit_record> getDeposit_records() {
		return deposit_records;
	}

	public void setDeposit_records(Set<Deposit_record> deposit_records) {
		this.deposit_records = deposit_records;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user_inf")
	public Set<User_score> getUser_scores() {
		return user_scores;
	}

	public void setUser_scores(Set<User_score> user_scores) {
		this.user_scores = user_scores;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user_inf")
	public Set<Spend_record> getSpend_records() {
		return spend_records;
	}

	public void setSpend_records(Set<Spend_record> spend_records) {
		this.spend_records = spend_records;
	}

	public String getU_photo() {
		return u_photo;
	}

	public void setU_photo(String u_photo) {
		this.u_photo = u_photo;
	}

}
