package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_product")
public class Product implements Serializable{

	private static final long serialVersionUID = 3864760169265940421L;
	
	@Id
	@GeneratedValue
	private Long proid;//产品编号
	@Column(nullable=false)
	private Long braid;//品牌编号
	@Column(nullable=false)
	private String name;//品牌名称
	@Column(nullable=false)
	private Long time;
	public Long getProid() {
		return proid;
	}
	public void setProid(Long proid) {
		this.proid = proid;
	}
	public Long getBraid() {
		return braid;
	}
	public void setBraid(Long braid) {
		this.braid = braid;
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
