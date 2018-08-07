package com.cqu.entity;
/*
 * @author CHT
 * @date 创建时间：2017年7月11日 下午4:25:48
 * @version 1.0
 */

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

@Entity
@Table(name = "commodity_inf")
public class Commodity_inf {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "c_id", unique = true, nullable = false)
	private Integer c_id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "b_id", nullable = false)
	private Business_inf business_inf;

	@Column(name = "c_name", nullable = false, length = 30)
	private String c_name;

	@Column(name = "c_price", nullable = false, precision = 8)
	private float c_price;

	@Column(name = "c_number")
	private int c_number;

	@Column(name = "c_desc")
	private String c_desc;

	@Column(name = "c_photo", length = 100)
	private String c_photo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "commodity_inf")
	private Set<Spend_record> spendRecords = new HashSet<Spend_record>(0);
	
	public Commodity_inf()
	{
		
	}
	
	public Commodity_inf(Integer c_id,Business_inf business_inf,String c_name,int c_number) {
		this.c_id=c_id;
		this.business_inf=business_inf;
		this.c_name=c_name;
		this.c_number = c_number;
	}
	
	public Commodity_inf(Integer c_id,Business_inf businessInf, String CName, float CPrice,
			int CNumber, String CDesc, String CPhoto) {
		this.c_id=c_id;
		this.business_inf = businessInf;
		this.c_name = CName;
		this.c_price = CPrice;
		this.c_number = CNumber;
		this.c_desc = CDesc;
		this.c_photo = CPhoto;
	}
	
	
	public Set<Spend_record> getSpendRecords() {
		return spendRecords;
	}

	public void setSpendRecords(Set<Spend_record> spendRecords) {
		this.spendRecords = spendRecords;
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public Business_inf getBusiness_inf() {
		return business_inf;
	}

	public void setBusiness_inf(Business_inf business_inf) {
		this.business_inf = business_inf;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public float getC_price() {
		return c_price;
	}

	public void setC_price(float c_price) {
		this.c_price = c_price;
	}

	public int getC_number() {
		return c_number;
	}

	public void setC_number(int c_number) {
		this.c_number = c_number;
	}

	public String getC_desc() {
		return c_desc;
	}

	public void setC_desc(String c_desc) {
		this.c_desc = c_desc;
	}

	public String getC_photo() {
		return c_photo;
	}

	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}

}
