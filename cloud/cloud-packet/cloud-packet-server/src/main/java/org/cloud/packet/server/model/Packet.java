package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="packet_packet")
public class Packet implements Serializable{

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
	private String depict;//描述
	@Column(nullable=false)
	private Long time;//时间
	@Column(nullable=false)
	private Integer state=Packet.STATE1;//-1已删除，0:异常，1：正常，
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
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}


	/**
	 * 已删除
	 */
	public static final int STATE_1=-1;
	/**
	 * 异常
	 */
	public static final int STATE0=0;
	/**
	 * 正常
	 */
	public static final int STATE1=1;

}
