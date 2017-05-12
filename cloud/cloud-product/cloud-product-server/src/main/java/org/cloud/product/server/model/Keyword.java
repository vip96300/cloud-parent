package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author admin
 *
 */

@Entity
@Table(name="product_category_search_keyword")
public class Keyword extends BaseModel implements Serializable{

	/**
	 * 关键字
	 */
	private static final long serialVersionUID = -3142854061384518875L;
	
	@Id
	@GeneratedValue
	private Long keyid;
	@Column(nullable=false)
	private Long seaid;//搜索编号
	@Column(nullable=false)
	private Long catid;//类目编号
	@Column(nullable=false)
	private String name;//名称
	@Column(nullable=false)
	private Long time;
	public Long getKeyid() {
		return keyid;
	}
	public void setKeyid(Long keyid) {
		this.keyid = keyid;
	}
	public Long getSeaid() {
		return seaid;
	}
	public void setSeaid(Long seaid) {
		this.seaid = seaid;
	}
	public Long getCatid() {
		return catid;
	}
	public void setCatid(Long catid) {
		this.catid = catid;
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
