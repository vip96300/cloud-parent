package org.cloud.waiter.client.controller.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

/**
 * 数据传输模型
 * @author admin
 *
 */
@ApiModel
public class Result <T>{
	
	public Result(int code,String depict,Object data){
		this.code=code;
		this.depict=depict;
		this.data=data;
	}
	/**
	 * 状态码
	 */
	@ApiModelProperty(value="状态码")
	private int code;
	/**
	 * 描述
	 */
	@ApiModelProperty(value="描述")
	private String depict;
	/**
	 * 数据
	 */
	@ApiModelProperty(value="数据")
	private Object data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDepict() {
		if(depict==null){
			depict="";
		}
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	public Object getData() {
		if(data==null){
			data=new ArrayList<T>();
		}
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
