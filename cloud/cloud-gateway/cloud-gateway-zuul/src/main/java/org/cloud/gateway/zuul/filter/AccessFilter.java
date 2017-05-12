package org.cloud.gateway.zuul.filter;

import com.netflix.zuul.ZuulFilter;
/**
 * 访问权限拦截器
 * @author XiaoHuiHui
 *
 */
public class AccessFilter extends ZuulFilter{
	public AccessFilter(){
		System.out.println("AccessFilter");
	}
	/**
	 * 拦截器实现
	 */
	@Override
	public Object run() {
		System.out.println("filter running...");
		return null;
	}
	@Override
	public boolean shouldFilter() {
		System.out.println("filter shoulding...");
		return false;
	}

	@Override
	public int filterOrder() {
		System.out.println("filter ordering...");
		return 0;
	}

	@Override
	public String filterType() {
		System.out.println("filter typing");
		return "pre";
	}

}
