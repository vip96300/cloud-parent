package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category_attribute_attValue")
public class AttValue implements Serializable{

	private static final long serialVersionUID = -8871759945813635178L;
	
	@Id
	@GeneratedValue
	private Long valId;
	@Column(nullable=false)
	private Long catId;//类目编号
	@Column(nullable=false)
	private Long attId;//属性编号
	@Column(nullable=false)
	private String name;//值名称
	@Column(nullable=false)
	private Long time;//创建时间

}
