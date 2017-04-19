package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_product_picture")
public class Picture implements Serializable{

	private static final long serialVersionUID = 7700383641712502454L;
	
	@Id
	@GeneratedValue
	private Long picid;
	@Column(nullable=false)
	private Long proid;//产品编号
	@Column(nullable=false)
	private String url;//地址
	@Column(nullable=false)
	private Long time;
	public Long getPicid() {
		return picid;
	}
	public void setPicid(Long picid) {
		this.picid = picid;
	}
	public Long getProid() {
		return proid;
	}
	public void setProid(Long proid) {
		this.proid = proid;
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
