package org.cloud.common.util;

import java.util.UUID;

public class UuidUtil {
	/**
	 * uuid 生成器
	 * @return
	 */
	public static String uuidBuilder(){
		return UUID.randomUUID().toString();
	}
}
