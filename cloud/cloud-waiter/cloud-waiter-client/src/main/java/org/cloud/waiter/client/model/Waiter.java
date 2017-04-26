package org.cloud.waiter.client.model;

public class Waiter{

	private Long waiid;

	private String userid;//用户编号

	private String username;//用户名

	private String telephone;//手机号

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
