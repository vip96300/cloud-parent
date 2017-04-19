package org.cloud.product.client.model;

public class Property{

	private Long proid;//编号
	private String attribute;//属性名
	private String value;//属性值
	private Long time;//创建时间
	
	public Long getProid() {
		return proid;
	}
	public void setProid(Long proid) {
		this.proid = proid;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
}
