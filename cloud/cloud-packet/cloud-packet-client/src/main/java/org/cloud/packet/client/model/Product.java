package org.cloud.packet.client.model;

public class Product{

	private Long proid;//产品编号
	private Long braid;//品牌编号
	private String name;//品牌名称
	private Long time;
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
