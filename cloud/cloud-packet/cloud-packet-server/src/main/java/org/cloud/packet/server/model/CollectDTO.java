package org.cloud.packet.server.model;


public class CollectDTO{


	private Long colid;

	private String userid;//用户编号

	private Long pacid;//优选包编号
	private String name;//别名
	private Long time;//创建时间
	public Long getColid() {
		return colid;
	}
	public void setColid(Long colid) {
		this.colid = colid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Long getPacid() {
		return pacid;
	}
	public void setPacid(Long pacid) {
		this.pacid = pacid;
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
