package org.cloud.packet.server.model;

import java.util.ArrayList;
import java.util.List;

public class GiftDTO{

	/**
	 * 礼物
	 */
	private Long gifid;

	private String name;//礼物名称
	private double sellprice;
	private Long time;//时间
	private int isdel;//是否删除
	private List<GifPicture> gifPictures=new ArrayList<GifPicture>();
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
	public List<GifPicture> getGifPictures() {
		return gifPictures;
	}
	public void setGifPictures(List<GifPicture> gifPictures) {
		this.gifPictures = gifPictures;
	}
	
	

}
