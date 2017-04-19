package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_category_attGroup")
public class AttGroup implements Serializable{

	private static final long serialVersionUID = -8871759945813635178L;
	/**
	 * 属性组
	 */
	@Id
	@GeneratedValue
	private Long groId;
	@Column(nullable=false)
	private Long catId;//类目编号
	@Column(nullable=false)
	private String name;//名称
	@Column(nullable=false)
	private Long time;//创建时间

}
