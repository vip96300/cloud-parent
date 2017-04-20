package org.cloud.common.util;

import java.util.Collection;

/**
 * 非空验证工具
 * @author admin
 *
 */
public class ValidUtil {
	/**
	 * 验证是否为空
	 * @param src
	 * @return
	 */
	public static boolean isValid(Object src){
		return !(src==null || "".equals(src.toString().trim()));
	}
	
	/**
	 * 验证集合是否为空
	 * @param collection
	 * @return
	 */
	public static boolean isValid(Collection<?> collection){
		if(collection==null || collection.isEmpty()){
			return false;
		}
		return true;
	}
}
