package org.cloud.user.server.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseModel implements Serializable{

	/**
	 * 模型抽象方法
	 */
	private static final long serialVersionUID = 8111357091545760266L;
	
	public int hashCode() {  
        return HashCodeBuilder.reflectionHashCode(this);  
    }  
  
    public String toString() {  
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);  
    }  
  
    public boolean equals(Object obj) {  
        return EqualsBuilder.reflectionEquals(this, obj);  
    }  

}
