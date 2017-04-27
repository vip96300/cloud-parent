package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="packet_category")
public class PacCategory extends BaseModel implements Serializable{

	/**
	 * 包类目
	 */
	private static final long serialVersionUID = -6455818176312881282L;
	
	@Id
	@GeneratedValue
	private Long catid;
	@Column(nullable=false)
	private Long pacid;//包名
	@Column(nullable=false)
	private Long categoryid;//类目编号
	@Column(nullable=false)
	private Long name;//名称
	@Column(nullable=false)
	private Long ismush;//是否必须
	@Column(nullable=false)
	private Long time;
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
	public Long getName() {
		return name;
	}
	public void setName(Long name) {
		this.name = name;
	}
	public Long getIsmush() {
		return ismush;
	}
	public void setIsmush(Long ismush) {
		this.ismush = ismush;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	

}
