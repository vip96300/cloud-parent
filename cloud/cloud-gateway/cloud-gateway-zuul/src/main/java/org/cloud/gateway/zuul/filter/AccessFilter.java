package org.cloud.gateway.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
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
		System.out.println("拦截器工作了0");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
		return null;
	}
	@Override
	public boolean shouldFilter() {
		System.out.println("拦截器工作了1");
		return false;
	}

	@Override
	public int filterOrder() {
		System.out.println("拦截器工作了2");
		return 0;
	}

	@Override
	public String filterType() {
		System.out.println("拦截器工作了3");
		return "pre";
	}

}
