package org.jgs1905.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 	测试过滤器01
 * @author junki
 * @date 2020年6月9日
 */
//@WebFilter("/*")
public class Filter01 implements Filter {

	/**
	 * 	初始化方法
	 * 	服务器启动时，会初始化一次，注意区别servlet
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter01初始化...");
	}
	
	/**
	 * 	执行过滤方法
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// HttpServletRequest --向上转型--> ServletRequest
		// ServletRequest --强制类型转换--> HttpServletRequest
		
		// FilterChain 过滤器链
		// 当项目启动时，所有的过滤器会初始化，然后会形成一条过滤器链（按照web.xml的注册顺序排序）
		// 当用户发送请求，首先被第一个过滤器接收，第一个过滤器执行doFilter完毕后决定是否放行。
		// 如果放行，执行chain.doFilter，把请求给到过滤器链，过滤器链会把请求给到第二个过滤器。
		// 如果过滤器链发现没有下一个过滤器了，完全放行请求，请求将由控制器接收处理。
		// 控制器响应后，响应会逐个逆序经过所有的过滤器，但是不是重新执行doFilter方法，而是执行chain.doFilter之后的代码。
		
		System.out.println("filter01执行过滤...");
		chain.doFilter(request, response); // 放行
		System.out.println("filter01过滤响应");
	}

	/**
	 * 	过滤器销毁方法
	 * 	服务器正常关闭时，执行一次
	 */
	@Override
	public void destroy() {
		System.out.println("filter01销毁...");
	}

}
