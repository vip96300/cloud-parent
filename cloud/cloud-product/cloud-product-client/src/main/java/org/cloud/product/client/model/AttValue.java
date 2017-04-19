package org.cloud.product.client.model;

public class AttValue{

	private Long valId;
	private Long catId;//类目编号
	private Long attId;//属性编号
	private String name;//值名称
	private Long time;//创建时间
	public Long getValId() {
		return valId;
	}
	public void setValId(Long valId) {
		this.valId = valId;
	}
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public Long getAttId() {
		return attId;
	}
	public void setAttId(Long attId) {
		this.attId = attId;
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
