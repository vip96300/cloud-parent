package org.cloud.product.admin.model;

public class Brand{

	private Long braid;

	private Long catid;//类目编号

	private String name;//品牌名称

	private String logo;//logo

	private Long time;

	public Long getBraid() {
		return braid;
	}

	public void setBraid(Long braid) {
		this.braid = braid;
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
