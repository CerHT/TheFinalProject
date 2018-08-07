package com.cqu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/*
 * @author CHT
 * @date 创建时间：2017年7月11日 下午3:54:12
 * @version 1.0
 */

@Entity
@Table(name = "base_inf", uniqueConstraints = @UniqueConstraint(columnNames = "account"))
public class Base_inf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "account", unique = true, nullable = false, length = 20)
	private String account;

	@Column(name = "password", nullable = false, length = 20)
	private String password;

	@Column(name = "type", nullable = false, length = 2)
	private Integer type;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "base_inf")
	private Set<User_inf> user_infs = new HashSet<User_inf>(0);

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "base_inf")
	private Set<Business_inf> business_infs = new HashSet<Business_inf>(0);

	
	public Base_inf()
	{
		
	}
	
	public Base_inf( String account, String password, Integer type) {
		this.password = password;
		this.account = account;
		this.type = type;
	}
	
	public Base_inf(String password, String account, Integer type,
			Set<User_inf> userInfs, Set<Business_inf> businessInfs) {
		this.password = password;
		this.account = account;
		this.type = type;
		this.user_infs = userInfs;
		this.business_infs = businessInfs;
	}
	
	public Set<User_inf> getUser_infs() {
		return user_infs;
	}

	public void setUser_infs(Set<User_inf> user_infs) {
		this.user_infs = user_infs;
	}

	public Set<Business_inf> getBusiness_infs() {
		return business_infs;
	}

	public void setBusiness_infs(Set<Business_inf> business_infs) {
		this.business_infs = business_infs;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
