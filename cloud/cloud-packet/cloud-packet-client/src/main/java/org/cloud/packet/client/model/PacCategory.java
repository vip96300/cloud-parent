package org.cloud.packet.client.model;

public class PacCategory{

	/**
	 * 包类目
	 */

	private Long catid;

	private Long pacid;//包名

	private Long categoryid;//类目编号
	
	private String name;//名称
	
	private Long ismush;//是否必须

	private Long time;
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public Long getPacid() {
		return pacid;
	}
	public void setPacid(Long pacid) {
		this.pacid = pacid;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getIsmush() {
		return ismush;
	}
	public void setIsmush(Long ismush) {
		this.ismush = ismush;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	

}
