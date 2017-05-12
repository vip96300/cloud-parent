package org.cloud.product.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="product_product")
public class Product extends BaseModel implements Serializable{

	private static final long serialVersionUID = 3864760169265940421L;
	
	@Id
	@GeneratedValue
	private Long proid;//产品编号
	@Column(nullable=false)
	private Long braid;//品牌编号
	@Column(nullable=false)
	private Long catid;//类目编号
	@Column(nullable=false)
	private String name;//产品名称
	@Column(nullable=false)
	private String braname;//品牌名称
	@Column(nullable=false)
	private Double discprice;//折扣价
	@Column(nullable=false)
	private Double sellprice;//销售价格
	@Pattern(regexp="^[^,](.*)[^,]$")
	@Column(nullable=false)
	private String keyword;//关键字
	@Column(nullable=false)
	private Long time;
	@Column(nullable=false)
	private Integer isdel;
	public Long getProid() {
		return proid;
	}
	public void setProid(Long proid) {
		this.proid = proid;
	}
	public Long getBraid() {
		return braid;
	}
	public void setBraid(Long braid) {
		this.braid = braid;
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
	public String getBraname() {
		return braname;
	}
	public void setBraname(String braname) {
		this.braname = braname;
	}
	public Double getDiscprice() {
		return discprice;
	}
	public void setDiscprice(Double discprice) {
		this.discprice = discprice;
	}
	public Double getSellprice() {
		return sellprice;
	}
	public void setSellprice(Double sellprice) {
		this.sellprice = sellprice;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Integer getIsdel() {
		return isdel;
	}
	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

}
