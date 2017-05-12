package org.cloud.packet.client.model;

public class Collect{

	/**
	 * 用户的包
	 */

	private Long useid;

	private String userid;//用户编号

	private String name;//别名

	private Long time;//创建时间
	public Long getUseid() {
		return useid;
	}
	public void setUseid(Long useid) {
		this.useid = useid;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	

}
