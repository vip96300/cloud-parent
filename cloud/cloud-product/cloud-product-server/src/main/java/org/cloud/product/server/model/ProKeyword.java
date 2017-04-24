package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product_category_product_keyword")
public class ProKeyword implements Serializable{

	/**
	 * 产品标签
	 */
	private static final long serialVersionUID = -9128604548771966891L;
	
	@Id
	@GeneratedValue
	private Long keyid;
	@Column(nullable=false)
	private Long proid;//产品编号
	@Column(nullable=false)
	private Long keywordid;//关键字编号
	@Column(nullable=false)
	private Long time;//时间
	public Long getKeyid() {
		return keyid;
	}
	public void setKeyid(Long keyid) {
		this.keyid = keyid;
	}
	public Long getProid() {
		return proid;
	}
	public void setProid(Long proid) {
		this.proid = proid;
	}
	public Long getKeywordid() {
		return keywordid;
	}
	public void setKeywordid(Long keywordid) {
		this.keywordid = keywordid;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	

}
