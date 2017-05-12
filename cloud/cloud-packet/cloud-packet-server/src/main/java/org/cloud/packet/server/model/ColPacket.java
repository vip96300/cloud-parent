package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="packet_collect_packet")
public class ColPacket extends BaseModel implements Serializable{

	private static final long serialVersionUID = -1003120861715678172L;
	@Id
	@GeneratedValue
	private Long pacid;
	@Column(nullable=false)
	private Long colid;//收藏编号
	@Column(nullable=false)
	private Long catid;//类目编号
	@Column(nullable=false)
	private Long proid;//产品编号
	@Column(nullable=false)
	private Long time;//创建时间
	
	public Long getPacid() {
		return pacid;
	}
	public void setPacid(Long pacid) {
		this.pacid = pacid;
	}
	public Long getColid() {
		return colid;
	}
	public void setColid(Long colid) {
		this.colid = colid;
	}
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
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
