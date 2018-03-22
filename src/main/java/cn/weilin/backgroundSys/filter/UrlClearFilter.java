package cn.weilin.backgroundSys.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

/**
 * 过滤器 使得第一次加载页面的时候去掉 静态资源文件后的jsession
 * @author Chen Weilin
 *
 */
public class UrlClearFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter");
		if (!(request instanceof HttpServletRequest)) {  
	           chain.doFilter(request, response);  
	           return;  
	       }  
	  
	       HttpServletRequest httpRequest = (HttpServletRequest) request;  
	       HttpServletResponse httpResponse = (HttpServletResponse) response;  
	  
	       // clear session if session id in URL  
	       if (httpRequest.isRequestedSessionIdFromURL()) {  
	           HttpSession session = httpRequest.getSession();  
	           if (session != null) session.invalidate();  
	       }  
	  
	       // wrap response to remove URL encoding  
	       HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpResponse) {  
	           @Override  
	           public String encodeRedirectUrl(String url) {  
	               return url;  
	           }  
	  
	           @Override  
	           public String encodeRedirectURL(String url) {  
	               return url;  
	           }  
	  
	           @Override  
	           public String encodeUrl(String url) {  
	               return url;  
	           }  
	  
	           @Override  
	           public String encodeURL(String url) {  
	               return url;  
	           }  
	       };
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}



}
