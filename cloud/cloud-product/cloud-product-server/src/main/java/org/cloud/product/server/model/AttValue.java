package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category_attribute_attValue")
public class AttValue implements Serializable{

	private static final long serialVersionUID = -8871759945813635178L;
	
	@Id
	@GeneratedValue
	private Long valId;
	@Column(nullable=false)
	private Long catId;//类目编号
	@Column(nullable=false)
	private Long attId;//属性编号
	@Column(nullable=false)
	private String name;//值名称
	@Column(nullable=false)
	private Long time;//创建时间
	public Long getValId() {
		return valId;
	}
	public void setValId(Long valId) {
		this.valId = valId;
	}
	public Long getCatId() {
		return catId;
	}
	public void setCatId(Long catId) {
		this.catId = catId;
	}
	public Long getAttId() {
		return attId;
	}
	public void setAttId(Long attId) {
		this.attId = attId;
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
