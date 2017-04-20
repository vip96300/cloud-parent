package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_product_property")
public class Property implements Serializable{

	private static final long serialVersionUID = -5590060083681820992L;
	
	@Id
	@GeneratedValue
	private Long proid;//编号
	@Column(nullable=false)
	private Long productid;//产品编号
	@Column(nullable=false)
	private Long attid;//属性编号
	@Column(nullable=false)
	private String attribute;//属性名
	@Column(nullable=false)
	private String value;//属性值
	@Column(nullable=false)
	private Long time;//创建时间
	public Long getProid() {
		return proid;
	}
	public void setProid(Long proid) {
		this.proid = proid;
	}
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
	}
	public Long getAttid() {
		return attid;
	}
	public void setAttid(Long attid) {
		this.attid = attid;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	
}
