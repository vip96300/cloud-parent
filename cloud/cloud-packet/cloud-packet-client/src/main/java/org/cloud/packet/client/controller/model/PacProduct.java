package org.cloud.packet.client.controller.model;

public class PacProduct{

	/**
	 * 包产品关联表
	 */

	private Long proid;

	private Long catid;//类目编号

	private Long productid;//产品编号

	private Long gitid;//礼物编号

	private Long time;
	public Long getProid() {
		return proid;
	}
	public void setProid(Long proid) {
		this.proid = proid;
	}
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
	}
	public Long getGitid() {
		return gitid;
	}
	public void setGitid(Long gitid) {
		this.gitid = gitid;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	
	
}
