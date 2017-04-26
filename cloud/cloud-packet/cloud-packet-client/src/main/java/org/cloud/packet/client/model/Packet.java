package org.cloud.packet.client.model;

public class Packet{

	/**
	 * 包
	 */

	private Long pacid;

	private String name;//名称

	private String depict;//描述

	private Long time;//时间
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
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	

}
