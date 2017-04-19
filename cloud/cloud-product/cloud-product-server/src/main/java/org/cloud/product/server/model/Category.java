package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category")
public class Category implements Serializable{

	private static final long serialVersionUID = -9148565883279080008L;
	
	@Id
	@GeneratedValue
	private Long catId;//类目编号
	private Long pid;//类目父编号
	@Column(nullable=false)
	private Integer isSku;//是否最小单位
	@Column(nullable=false)
	private String name;//名称
	@Column(nullable=false)
	private Long time;//创建时间

}
