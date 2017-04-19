package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category_attribute_attvalue")
public class AttValue implements Serializable{

	private static final long serialVersionUID = -8871759945813635178L;
	
	@Id
	@GeneratedValue
	private Long valid;
	@Column(nullable=false)
	private Long catid;//类目编号
	@Column(nullable=false)
	private Long attid;//属性编号
	@Column(nullable=false)
	private String name;//值名称
	@Column(nullable=false)
	private Long time;//创建时间
	public Long getValid() {
		return valid;
	}
	public void setValid(Long valid) {
		this.valid = valid;
	}
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public Long getAttid() {
		return attid;
	}
	public void setAttid(Long attid) {
		this.attid = attid;
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
