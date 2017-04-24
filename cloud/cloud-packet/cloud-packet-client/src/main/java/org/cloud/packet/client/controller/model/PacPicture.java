package org.cloud.packet.client.controller.model;

public class PacPicture{

	/**
	 * 包图片
	 */

	private Long picid;

	private String url;//路径

	private Long pacid;//包编号

	private Integer type;//图片类型，0效果图，1：封面图，2：列表图

	private Long time;
	public Long getPicid() {
		return picid;
	}
	public void setPicid(Long picid) {
		this.picid = picid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getPacid() {
		return pacid;
	}
	public void setPacid(Long pacid) {
		this.pacid = pacid;
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
