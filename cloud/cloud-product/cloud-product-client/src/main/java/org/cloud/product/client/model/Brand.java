package org.cloud.product.client.model;

public class Brand{

	private Long braId;

	private Long catId;//类目编号

	private String name;//品牌名称

	private String logo;//logo

	private Long time;

	public Long getBraId() {
		return braId;
	}

	public void setBraId(Long braId) {
		this.braId = braId;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}


}
