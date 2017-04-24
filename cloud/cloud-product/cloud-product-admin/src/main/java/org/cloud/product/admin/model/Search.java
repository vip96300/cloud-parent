package org.cloud.product.admin.model;

public class Search {

	private Long seaid;

	private Long catid;// 类目编号

	private String name;// 名称

	private Long time;// 时间

	public Long getSeaid() {
		return seaid;
	}

	public void setSeaid(Long seaid) {
		this.seaid = seaid;
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
