package org.cloud.product.client.model;

public class Keyword{

	private Long keyid;

	private Long seaid;//搜索编号

	private String name;//名称

	private Long time;
	public Long getKeyid() {
		return keyid;
	}
	public void setKeyid(Long keyid) {
		this.keyid = keyid;
	}
	public Long getSeaid() {
		return seaid;
	}
	public void setSeaid(Long seaid) {
		this.seaid = seaid;
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
