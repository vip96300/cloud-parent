package org.cloud.common.util;

public class FileUtil {
	/**
	 * 获取文件后缀名
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String fileName){
		String suffix = null;
		try {
			suffix=fileName.substring(fileName.lastIndexOf("."));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suffix;
	}
	
}
