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
	private String name;//名称
	@Column(nullable=false)
	private String surface;//封面
	@Column(nullable=false)
	private Integer ismust;//是否必须
	@Column
	private Long proid;//产品编号，如果为空代码非固定
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public Integer getIsmust() {
		return ismust;
	}
	public void setIsmust(Integer ismust) {
		this.ismust = ismust;
	}
	public Long getProid() {
		return proid;
	}
	public void setProid(Long proid) {
		this.proid = proid;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	

}
