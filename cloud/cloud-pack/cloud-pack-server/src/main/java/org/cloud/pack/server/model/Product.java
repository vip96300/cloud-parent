package org.cloud.pack.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pack_product")
public class Product implements Serializable{

	/**
	 * product
	 */
	private static final long serialVersionUID = 2397810970989757766L;
	
	@Id
	@GeneratedValue
	private String proId;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private Long time;

	
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
