package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="packet_packet_user")
public class PacUser implements Serializable{

	/**
	 * 用户的包
	 */
	private static final long serialVersionUID = 8694095083900603067L;
	
	@Id
	@GeneratedValue
	private Long useid;
	@Column(nullable=false)
	private String userid;//用户编号
	@Column(nullable=false)
	private Long pacid;//包编号
	@Column(nullable=false)
	private String name;//别名
	@Column(nullable=false)
	private Long time;//创建时间
	public Long getUseid() {
		return useid;
	}
	public void setUseid(Long useid) {
		this.useid = useid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
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
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	

}
