package org.cloud.product.admin.model;

public class AttValue{

	private Long valid;
	private Long catid;//类目编号
	private Long attid;//属性编号
	private String name;//值名称
	private Long time;//创建时间
	public Long getValid() {
		return valid;
	}
	public void setValid(Long valid) {
		this.valid = valid;
	}
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public Long getAttid() {
		return attid;
	}
	public void setAttid(Long attid) {
		this.attid = attid;
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
