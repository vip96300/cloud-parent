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
	private Long picId;
	@Column(nullable=false)
	private Long proId;//产品编号
	@Column(nullable=false)
	private String url;//地址
	@Column(nullable=false)
	private Long time;


}
