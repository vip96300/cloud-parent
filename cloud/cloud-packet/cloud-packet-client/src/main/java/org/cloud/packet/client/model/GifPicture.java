package org.cloud.packet.client.model;

public class GifPicture{

	
	private Long picid;

	private Long gifid;//礼物编号

	private Integer type;//类型0效果图，1列表图

	private String url;//路径

	private Long time;
	public Long getPicid() {
		return picid;
	}
	public void setPicid(Long picid) {
		this.picid = picid;
	}
	public Long getGifid() {
		return gifid;
	}
	public void setGifid(Long gifid) {
		this.gifid = gifid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
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
