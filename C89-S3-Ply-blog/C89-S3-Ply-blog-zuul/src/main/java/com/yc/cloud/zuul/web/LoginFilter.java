package com.yc.cloud.zuul.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * ZuulFilter 是什么？
 *	A 接口， B 类， C 抽象类
 */
@Component
public class LoginFilter extends ZuulFilter {

	// Criteria: 执行的条件，即该过滤器何时会被触发;
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// 获取请求上下文（zuul提供）
		RequestContext ctx = RequestContext.getCurrentContext();
		// 获取请求对象
		HttpServletRequest request = ctx.getRequest();
		//获取传来的参数accessToken ==》 访问令牌
		Object accessToken = request.getParameter("accessToken");
		// 根据你的IP 端口 浏览器的版本。。。为你生成唯一的令牌
		// 好处是不需要会话的参与 ==》 关闭会话容器
		if (accessToken == null) {
			// 没有令牌
			System.err.println("access token is empty");
			//过滤该请求，不往下级服务去转发请求，到此结束
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			ctx.setResponseBody("{\"result\":\"accessToken is empty!\"}");
			return null;
		}
		//如果有token，则进行路由转发, 这里return的值没有意义，zuul框架没有使用该返回值
		return null;
	}

	//Type: 定义在请求执行过程中何时被执行;   pre    post   route
	@Override
	public String filterType() {
		return "pre";
	}

	// Execution Order: 当存在多个过滤器时，用来指示执行的顺序，值越小就会越早执行;
	@Override
	public int filterOrder() {
		return 0;
	}

}
