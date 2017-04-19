package org.cloud.product.client.model;

public class Product{

	private Long proId;//产品编号
	private Long braId;//品牌编号
	private String name;//品牌名称
	private Long time;
	public Long getProId() {
		return proId;
	}
	public void setProId(Long proId) {
		this.proId = proId;
	}
	public Long getBraId() {
		return braId;
	}
	public void setBraId(Long braId) {
		this.braId = braId;
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
