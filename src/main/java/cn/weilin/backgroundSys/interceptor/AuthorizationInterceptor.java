package cn.weilin.backgroundSys.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.weilin.backgroundSys.entity.Admin;

/**
 * 登录授权拦截器
 * 根据session判断是否登录或超时，若未登录则跳转到登录页面
 * @author Chen Weilin
 *
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

	//不拦截的请求
	private static final String[] IGNORE_URI = {"/loginForm", "login"};
	
	/**
	 * 在preHandle方法内进行拦截，该方法将会在Controller处理之前调用
	 * 返回值为true往下执行，否则整个请求结束
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//flag表示是否登录，默认未登录
		boolean flag = false;
		//判断是否该请求需要拦截
		String servletPath = request.getServletPath();
		for (String s : IGNORE_URI) {
			if (servletPath.contains(s)) {
				//不需要拦截
				flag = true;
				break;
			}
		}
		if (!flag) {
			//请求被拦截
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			if (admin == null) {
				//用户未登录
				response.sendRedirect(request.getContextPath()+"/admin/login");
			} else {
				//已登录，判断是否过期
				long nowTime = new Date().getTime();
				long adminLoginTime = (long) request.getSession().getAttribute("adminLoginTime");
				if (nowTime - adminLoginTime >= 3600000) {	
					//过期
					response.sendRedirect(request.getContextPath()+"/admin/login");
				} else {
					//未过期，刷新登录时间
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
