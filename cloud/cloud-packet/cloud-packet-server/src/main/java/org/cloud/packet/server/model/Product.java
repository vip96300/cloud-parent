package org.cloud.packet.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Long catid;
	@Column(nullable=false)
	private String name;//名称
	@Column(nullable=false)
	private Long time;
	@Column(nullable=false)
	private Integer state=Product.STATE1;//产品状态,-1已删除，0:异常，1：正常，
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
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}


	/**
	 * 普通产品类型代码
	 */
	public static final int TYPE0=0;
	
	/**
	 * 已删除
	 */
	public static final int STATE_1=-1;
	/**
	 * 异常
	 */
	public static final int STATE0=0;
	/**
	 * 正常
	 */
	public static final int STATE1=1;
	

}
