package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category_attribute")
public class Attribute implements Serializable{

	private static final long serialVersionUID = -4187369360003107593L;
	
	@Id
	@GeneratedValue
	private Long attid;//编号
	@Column(nullable=false)
	private Long groid;//属性组编号
	@Column(nullable=false)
	private Long catid;//类目编号
	@Column(nullable=false)
	private String name;//属性名称
	@Column(nullable=false)
	private Integer type;//属性类型/0：输入框，1：单选框，2：多选框
	@Column(nullable=false)
	private Long time;//创建时间
	
	public Long getAttid() {
		return attid;
	}
	public void setAttid(Long attid) {
		this.attid = attid;
	}
	public Long getGroid() {
		return groid;
	}
	public void setGroid(Long groid) {
		this.groid = groid;
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	/**
	 * 文本
	 */
	public static final int T0=0;
	/**
	 * 单选
	 */
	public static final int T1=1;
	/**
	 * 多选
	 */
	public static final int T2=2;
	
}
