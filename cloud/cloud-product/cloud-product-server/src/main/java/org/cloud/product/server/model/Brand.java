package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category_brand")
public class Brand implements Serializable{

	private static final long serialVersionUID = -2633285465391055206L;
	
	@Id
	@GeneratedValue
	private Long braId;
	@Column(nullable=false)
	private Long catId;//类目编号
	@Column(nullable=false)
	private String name;//品牌名称
	@Column(nullable=false)
	private String logo;
	@Column(nullable=false)
	private Long time;


}
