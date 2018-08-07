package com.cqu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
 * @author CHT
 * @date 创建时间：2017年7月11日 下午5:23:39
 * @version 1.0
 */

@SuppressWarnings("serial")
@Embeddable
public class UserScoreId implements Serializable{
	private Integer u_id;
	private Integer b_id;
	
	
	public UserScoreId()
	{
		
	}
	
	public UserScoreId(Integer uid,Integer bid)
	{
		this.u_id=uid;
		this.b_id=bid;
	}

	
	@Column(name = "u_id", nullable = false)
	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	@Column(name = "b_id", nullable = false)
	public Integer getB_id() {
		return b_id;
	}

	public void setB_id(Integer b_id) {
		this.b_id = b_id;
	}
	
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserScoreId))
			return false;
		UserScoreId castOther = (UserScoreId) other;

		return ((this.getU_id() == castOther.getU_id()) || (this.getU_id() != null
				&& castOther.getU_id() != null && this.getU_id().equals(
				castOther.getU_id())))
				&& ((this.getB_id() == castOther.getB_id()) || (this.getB_id() != null
						&& castOther.getB_id() != null && this.getB_id().equals(
						castOther.getB_id())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getU_id() == null ? 0 : this.getU_id().hashCode());
		result = 37 * result
				+ (getB_id() == null ? 0 : this.getB_id().hashCode());
		return result;
	}
}
