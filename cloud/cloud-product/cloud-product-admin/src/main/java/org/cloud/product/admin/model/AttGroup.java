package org.cloud.product.admin.model;

public class AttGroup{

	/**
	 * 属性组
	 */
	private Long groid;
	private Long catid;//类目编号

	private String name;//名称

	private Long time;//创建时间

	public Long getGroid() {
		return groid;
	}

	public void setGroid(Long groid) {
		this.groid = groid;
	}

	public Long getCatid() {
		return catid;
	}

	public void setCatid(Long catid) {
		this.catid = catid;
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
