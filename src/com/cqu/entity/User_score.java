package com.cqu.entity;
/*
 * @author CHT
 * @date 创建时间：2017年7月11日 下午5:13:09
 * @version 1.0
 */

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_score")
public class User_score {
	
	private UserScoreId id;
	private User_inf user_inf;
	private Business_inf business_inf;
	private float score;
	
	
	public User_score()
	{
		
	}
	
	public User_score(UserScoreId id,Business_inf businessInf) {
		this.id = id;
		this.business_inf = businessInf;
	}
	
	
	public User_score(UserScoreId id,Business_inf businessInf,
			float score) {
		this.id = id;
		this.business_inf = businessInf;
		this.score = score;
	}

	
	@EmbeddedId
	@AttributeOverrides({
		@AttributeOverride(name="u_id",column=@Column(name="u_id",nullable=false)),
		@AttributeOverride(name="b_id",column=@Column(name="b_id",nullable=false))
	})
	public UserScoreId getId() {
		return id;
	}

	public void setId(UserScoreId id) {
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
	@JoinColumn(name = "b_id", nullable = false, insertable = false, updatable = false)
	public Business_inf getBusiness_inf() {
		return business_inf;
	}

	public void setBusiness_inf(Business_inf business_inf) {
		this.business_inf = business_inf;
	}

	@Column(name = "score", precision = 10)
	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	
	
	
}
