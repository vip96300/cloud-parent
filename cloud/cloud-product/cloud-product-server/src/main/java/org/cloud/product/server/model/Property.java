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
	private Long proId;//编号
	@Column(nullable=false)
	private String attribute;//属性名
	@Column(nullable=false)
	private String value;//属性值
	@Column(nullable=false)
	private Long time;//创建时间

}