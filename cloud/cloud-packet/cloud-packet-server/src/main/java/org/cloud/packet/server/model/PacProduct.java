package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="packet_category_product")
public class PacProduct implements Serializable{

	/**
	 * 包产品关联表
	 */
	private static final long serialVersionUID = 303155201494125862L;
	
	@Id
	@GeneratedValue
	private Long proid;
	@Column(nullable=false)
	private Long catid;//类目编号
	@Column(nullable=false)
	private Long productid;//产品编号
	@Column(nullable=false)
	private Long gitid;//礼物编号
	@Column(nullable=false)
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
