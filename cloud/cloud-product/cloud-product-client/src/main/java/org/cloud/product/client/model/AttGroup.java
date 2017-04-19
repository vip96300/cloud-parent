package org.cloud.product.client.model;

public class AttGroup{

	/**
	 * 属性组
	 */
	private Long groId;
	private Long catId;//类目编号

	private String name;//名称

	private Long time;//创建时间

	public Long getGroId() {
		return groId;
	}

	public void setGroId(Long groId) {
		this.groId = groId;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
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
