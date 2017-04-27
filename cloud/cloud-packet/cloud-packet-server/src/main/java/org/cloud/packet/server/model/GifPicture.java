package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="packet_gift_picture")
public class GifPicture extends BaseModel implements Serializable{

	/**
	 * 礼物图片
	 */
	private static final long serialVersionUID = -424384846831209549L;
	
	@Id
	@GeneratedValue
	private Long picid;
	@Column(nullable=false)
	private Long gifid;//礼物编号
	@Column(nullable=false)
	private Integer type;//类型0效果图，1列表图
	@Column(nullable=false)
	private String url;//路径
	@Column(nullable=false)
	private Long time;
	public Long getPicid() {
		return picid;
	}
	public void setPicid(Long picid) {
		this.picid = picid;
	}
	public Long getGifid() {
		return gifid;
	}
	public void setGifid(Long gifid) {
		this.gifid = gifid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	

}
