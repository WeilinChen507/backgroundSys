package cn.weilin.backgroundSys.interceptor;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.weilin.backgroundSys.entity.Admin;
import cn.weilin.backgroundSys.entity.Rule;

/**
 * 遵从数据库中超管指定的rule权限表拦截请求
 * @author Chen Weilin
 *
 */
public class RuleInterceptor implements HandlerInterceptor{

	private static final String[] IGNORE_URI = {"login", "logout"};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//flag means if it's needed for intercepted, default needed
		boolean flag = false;
		String servletPath = request.getServletPath();
		for (String s : IGNORE_URI) {
			if (servletPath.contains(s)) {
				//no need
				return true;
			}
		}
		//cut the part of page, like "/developer_module/rule_list/2" to "/developer_module/rule_list"
		/*if (servletPath.matches(".+\\d+$")) {
			int i = servletPath.lastIndexOf("/");
			servletPath = servletPath.substring(0, i);
		}
		no need for judging if there's this part
		*/
		if (!flag) {
			Admin admin = (Admin)request.getSession().getAttribute("admin");
			List<Rule> ruleList =  admin.getRuleList();
			for(Rule rule : ruleList) {
				if (servletPath.contains(rule.getRule())) {
					flag = true;
				}
			}
		}
		if (!flag) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script language='javascript'>alert('您无此操作权限，请联系管理员');window.location.href='"+
					request.getHeader("Referer") +"';</script>");
			//redirect to last url
			//response.sendRedirect(request.getHeader("Referer"));
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
