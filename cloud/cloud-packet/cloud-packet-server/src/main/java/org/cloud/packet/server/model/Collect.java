package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="packet_collect")
public class Collect extends BaseModel implements Serializable{

	/**
	 * 收藏
	 */
	private static final long serialVersionUID = -8802297186090586749L;
	
	@Id
	@GeneratedValue
	private Long colid;
	@Column(nullable=false)
	private String userid;//用户编号
	@Column(nullable=false)
	private Long pacid;//优选包编号
	@Column(nullable=false)
	private String name;//别名
	@Column(nullable=false)
	private Long time;//创建时间
	public Long getColid() {
		return colid;
	}
	public void setColid(Long colid) {
		this.colid = colid;
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
