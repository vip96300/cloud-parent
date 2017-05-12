package org.cloud.packet.client.model;

public class Gift{

	/**
	 * 礼物
	 */
	private Long gifid;

	private String name;//礼物名称
	private double sellprice;
	private Long time;//时间
	private int isdel;//是否删除
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
	
	public double getSellprice() {
		return sellprice;
	}
	public void setSellprice(double sellprice) {
		this.sellprice = sellprice;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
	
	

}
