package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class Category extends BaseModel implements Serializable{

	private static final long serialVersionUID = -9148565883279080008L;
	
	@Id
	@GeneratedValue
	private Long catid;//类目编号
	@Column(nullable=false)
	private Long pid;//类目父编号
	@Column(nullable=false)
	private Integer issku;//是否最小单位
	@Column(nullable=false)
	private String name;//名称
	@Column(nullable=false)
	private Long time;//创建时间
	@Column(nullable=false)
	private int isdel;//是否删除
	
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Integer getIssku() {
		return issku;
	}
	public void setIssku(Integer issku) {
		this.issku = issku;
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
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
	
}
