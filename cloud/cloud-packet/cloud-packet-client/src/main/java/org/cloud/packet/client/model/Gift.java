package org.cloud.packet.client.model;

public class Gift{

	/**
	 * 礼物
	 */
	private Long gifid;

	private String name;//礼物名称

	private Long time;//时间
	public Long getGifid() {
		return gifid;
	}
	public void setGifid(Long gifid) {
		this.gifid = gifid;
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
