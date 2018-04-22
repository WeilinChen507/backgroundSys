package cn.weilin.backgroundSys.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.weilin.backgroundSys.entity.Admin;

/**
 * 登录拦截器
 * @author Chen Weilin
 *
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

	//需要忽略拦截的请求
	private static final String[] IGNORE_URI = {"login", "logout"};
	
	/**
	 * 通过session判断是否登录
	 * 将未登录的拦截并跳转至登录页面
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//flag表示有无登录 默认为false
		boolean flag = false;
		//判断是否是需要拦截
		String servletPath = request.getServletPath();
		for (String s : IGNORE_URI) {
			if (servletPath.contains(s)) {
				//不需要拦截
				flag = true;
				break;
			}
		}
		if (!flag) {
			//需要拦截
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			if (admin == null) {
				//未登录
				response.sendRedirect(request.getContextPath()+"/admin/login");
			} else {
				//判断登录是否超时 默认为1小时
				long nowTime = new Date().getTime();
				long adminLoginTime = (long) request.getSession().getAttribute("adminLoginTime");
				if (nowTime - adminLoginTime >= 3600000) {	
					//登录超时
					response.sendRedirect(request.getContextPath()+"/admin/login");
				} else {
					//已登录 不超时 更新登录时间至session
					request.getSession().setAttribute("adminLoginTime", nowTime);
					flag = true;
				}
			}
		}
		return flag;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {		
	}

}
