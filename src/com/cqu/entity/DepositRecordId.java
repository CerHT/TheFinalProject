package com.cqu.entity;
/*
 * @author CHT
 * @date 创建时间：2017年7月11日 下午5:22:09
 * @version 1.0
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class DepositRecordId implements Serializable{

	private String time;
	private Integer u_id;

	public DepositRecordId() {

	}

	public DepositRecordId(String time, Integer u_id) {
		this.time = time;
		this.u_id = u_id;
	}

	@Column(name = "time", nullable = false, length = 50)
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "u_id", nullable = false)
	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DepositRecordId))
			return false;
		DepositRecordId castOther = (DepositRecordId) other;

		return ((this.getTime() == castOther.getTime()) || (this.getTime() != null
				&& castOther.getTime() != null && this.getTime().equals(
				castOther.getTime())))
				&& ((this.getU_id() == castOther.getU_id()) || (this.getU_id() != null
						&& castOther.getU_id() != null && this.getU_id().equals(
						castOther.getU_id())));
	}
	
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		result = 37 * result
				+ (getU_id() == null ? 0 : this.getU_id().hashCode());
		return result;
	}
	
}
