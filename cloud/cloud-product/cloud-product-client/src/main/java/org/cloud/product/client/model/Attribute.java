package org.cloud.product.client.model;

public class Attribute{

	private Long attid;//编号

	private Long groid;//属性组编号
	
	private long catid;//类目编号

	private String name;//属性名称

	private Integer type;//是否可选0输入框，1单选框，2多选框

	private Long time;//创建时间

	public Long getAttid() {
		return attid;
	}

	public void setAttid(Long attid) {
		this.attid = attid;
	}

	public Long getGroid() {
		return groid;
	}

	public void setGroid(Long groid) {
		this.groid = groid;
	}

	public long getCatid() {
		return catid;
	}

	public void setCatid(long catid) {
		this.catid = catid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	

	
}
