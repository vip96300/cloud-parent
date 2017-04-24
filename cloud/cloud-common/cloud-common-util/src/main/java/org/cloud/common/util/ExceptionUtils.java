package org.cloud.common.util;

/**
 * 自定义异常工具类
 * @author admin
 *
 */
public class ExceptionUtils {
	
	
	class ServerConnectException extends Exception{

		/**
		 * 服务连接失败异常
		 */
		private static final long serialVersionUID = -50350684231378239L;

		public ServerConnectException(){
			super("server connect exception");
		}
		
		public ServerConnectException(String message){
			super(message);
		}
		
	}
}
