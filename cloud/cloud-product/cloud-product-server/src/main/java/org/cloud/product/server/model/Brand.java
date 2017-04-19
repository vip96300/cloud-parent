package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category_brand")
public class Brand implements Serializable{

	private static final long serialVersionUID = -2633285465391055206L;
	
	@Id
	@GeneratedValue
	private Long braid;
	@Column(nullable=false)
	private Long catid;//类目编号
	@Column(nullable=false)
	private String name;//品牌名称
	@Column(nullable=false)
	private String logo;
	@Column(nullable=false)
	private Long time;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	

}
