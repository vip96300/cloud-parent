package org.cloud.waiter.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="waiter_waiter")
public class Waiter implements Serializable{

	/**
	 * 服务员
	 */
	private static final long serialVersionUID = -3965090519120642913L;
	
	@Id
	@GeneratedValue
	private Long waiid;
	@Column(nullable=false)
	private String userid;//用户编号
	@Column(nullable=false)
	private String username;//用户名
	@Column(nullable=false)
	private String telephone;//手机号
	@Column(nullable=false)
	private Long time;//创建时间
	
	public Long getWaiid() {
		return waiid;
	}
	public void setWaiid(Long waiid) {
		this.waiid = waiid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	

}
