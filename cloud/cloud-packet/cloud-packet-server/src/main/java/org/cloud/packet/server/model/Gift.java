package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="packet_gift")
public class Gift implements Serializable{

	/**
	 * 礼物
	 */
	private static final long serialVersionUID = 1654741463279894596L;
	
	@Id
	@GeneratedValue
	private Long gifid;
	@Column(nullable=false)
	private String name;//礼物名称
	@Column(nullable=false)
	private Long time;//时间
	public Long getGifid() {
		return gifid;
	}
	public void setGifid(Long gifid) {
		this.gifid = gifid;
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
