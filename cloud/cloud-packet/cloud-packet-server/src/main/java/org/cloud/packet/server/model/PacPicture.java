package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="packet_packet_picture")
public class PacPicture extends BaseModel implements Serializable{

	/**
	 * 包图片
	 */
	private static final long serialVersionUID = -4471021120001336074L;
	
	@Id
	@GeneratedValue
	private Long picid;
	@Column(nullable=false)
	private String url;//路径
	@Column(nullable=false)
	private Long pacid;//包编号
	@Column(nullable=false)
	private Integer type;//图片类型，0效果图，1：封面图，2：列表图
	@Column(nullable=false)
	private Long time;
	public Long getPicid() {
		return picid;
	}
	public void setPicid(Long picid) {
		this.picid = picid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getPacid() {
		return pacid;
	}
	public void setPacid(Long pacid) {
		this.pacid = pacid;
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
	
	
}
