package org.cloud.packet.client.model;

public class PacCategory{

	/**
	 * 包类目
	 */

	private Long catid;

	private Long pacid;//包名

	private Long categoryid;//类目编号
	
	private String name;//名称
	
	private int ismust;//是否必须
	
	private String surface;//封面
	
	private long proid;//产品编号
	
	private Long time;
	
	private Product product;
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public Long getPacid() {
		return pacid;
	}
	public void setPacid(Long pacid) {
		this.pacid = pacid;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsmust() {
		return ismust;
	}
	public void setIsmust(int ismust) {
		this.ismust = ismust;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public long getProid() {
		return proid;
	}
	public void setProid(long proid) {
		this.proid = proid;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
