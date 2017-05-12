package org.cloud.packet.server.model;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO{

	private Long proid;//产品编号
	private Long braid;//品牌编号
	private Long catid;//类目编号
	private String name;//产品名称
	private String braname;//品牌名称
	private Double discprice;//折扣价
	private Double sellprice;//销售价格
	private String keyword;//关键字
	private int isdel;//是否删除
	private Long time;
	private List<PictureDTO> pictures=new ArrayList<PictureDTO>();
	private GiftDTO giftDTO=new GiftDTO();
	public Long getProid() {
		return proid;
	}
	public void setProid(Long proid) {
		this.proid = proid;
	}
	public Long getBraid() {
		return braid;
	}
	public void setBraid(Long braid) {
		this.braid = braid;
	}
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBraname() {
		return braname;
	}
	public void setBraname(String braname) {
		this.braname = braname;
	}
	public Double getDiscprice() {
		return discprice;
	}
	public void setDiscprice(Double discprice) {
		this.discprice = discprice;
	}
	public Double getSellprice() {
		return sellprice;
	}
	public void setSellprice(Double sellprice) {
		this.sellprice = sellprice;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public List<PictureDTO> getPictures() {
		return pictures;
	}
	public void setPictures(List<PictureDTO> pictures) {
		this.pictures = pictures;
	}
	public GiftDTO getGiftDTO() {
		return giftDTO;
	}
	public void setGiftDTO(GiftDTO giftDTO) {
		this.giftDTO = giftDTO;
	}

	
}
