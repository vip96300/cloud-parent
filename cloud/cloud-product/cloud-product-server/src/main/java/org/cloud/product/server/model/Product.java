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
	private Long proId;//产品编号
	@Column(nullable=false)
	private Long braId;//品牌编号
	@Column(nullable=false)
	private String name;//品牌名称
	@Column(nullable=false)
	private Long time;


}
