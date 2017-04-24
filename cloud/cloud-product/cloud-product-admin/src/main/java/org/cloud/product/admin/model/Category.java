package org.cloud.product.admin.model;

public class Category{

	private Long catid;//类目编号
	private Long pid;//类目父编号
	private Integer issku;//是否最小单位
	private String name;//名称
	private Long time;//创建时间
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Integer getIssku() {
		return issku;
	}
	public void setIssku(Integer issku) {
		this.issku = issku;
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
