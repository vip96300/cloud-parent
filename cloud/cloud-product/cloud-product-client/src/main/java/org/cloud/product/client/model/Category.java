package org.cloud.product.client.model;

public class Category{

	private Long catId;//类目编号
	private Long pid;//类目父编号
	private Integer isSku;//是否最小单位
	private String name;//名称
	private Long time;//创建时间
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Integer getIsSku() {
		return isSku;
	}
	public void setIsSku(Integer isSku) {
		this.isSku = isSku;
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
