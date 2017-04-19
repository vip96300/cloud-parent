package org.cloud.product.client.model;

public class Attribute{

	private Long attId;//编号

	private Long groId;//属性组编号
	
	private long catId;//类目编号

	private String name;//属性名称

	private Integer type;//是否可选0输入框，1单选框，2多选框

	private Long time;//创建时间

	public Long getAttId() {
		return attId;
	}

	public void setAttId(Long attId) {
		this.attId = attId;
	}

	public Long getGroId() {
		return groId;
	}

	public void setGroId(Long groId) {
		this.groId = groId;
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
