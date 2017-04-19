package org.cloud.product.client.model;

public class Picture{
	
	private Long picid;
	private Long proid;//产品编号
	private String url;//地址
	private Long time;
	public Long getPicid() {
		return picid;
	}
	public void setPicid(Long picid) {
		this.picid = picid;
	}
	public Long getProid() {
		return proid;
	}
	public void setProid(Long proid) {
		this.proid = proid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	

}
