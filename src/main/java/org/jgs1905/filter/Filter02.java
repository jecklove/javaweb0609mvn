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
 * 	测试过滤器02
 * @author junki
 * @date 2020年6月9日
 */
//@WebFilter("/*")
public class Filter02 implements Filter {

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter02初始化...");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter02执行过滤...");
		chain.doFilter(request, response);
		System.out.println("filter02过滤响应");
	}

	@Override
	public void destroy() {
		System.out.println("filter02销毁...");
	}

}
