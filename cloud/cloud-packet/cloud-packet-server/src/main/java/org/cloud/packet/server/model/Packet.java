package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="packet_packet")
public class Packet extends BaseModel implements Serializable{

	/**
	 * 包
	 */
	private static final long serialVersionUID = -9003353019960757531L;
	
	@Id
	@GeneratedValue
	private Long pacid;
	@Column(nullable=false)
	private String name;//名称
	@Column(nullable=false)
	private String title;//标题
	@Column(nullable=false)
	private String depict;//描述
	@Column(nullable=false)
	private String surface;//封面
	@Column(nullable=false)
	private String banner;//横幅
	@Column(nullable=false)
	private Integer ispk;//是否主要
	@Column(nullable=false)
	private Long time;//时间
	@Column(nullable=false)
	private Integer isdel=0;//-1已删除，0:异常，1：正常，
	public Long getPacid() {
		return pacid;
	}
	public void setPacid(Long pacid) {
		this.pacid = pacid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	public String getSurface() {
		return surface;
	}
	public void setSurface(String surface) {
		this.surface = surface;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public Integer getIspk() {
		return ispk;
	}
	public void setIspk(Integer ispk) {
		this.ispk = ispk;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Integer getIsdel() {
		return isdel;
	}
	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}




}
