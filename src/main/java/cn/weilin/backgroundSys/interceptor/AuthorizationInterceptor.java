package cn.weilin.backgroundSys.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.weilin.backgroundSys.entity.Admin;

/**
 * ��¼��Ȩ������
 * ����session�ж��Ƿ��¼��ʱ����δ��¼����ת����¼ҳ��
 * @author Chen Weilin
 *
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

	//�����ص�����
	private static final String[] IGNORE_URI = {"/loginForm", "login"};
	
	/**
	 * ��preHandle�����ڽ������أ��÷���������Controller����֮ǰ����
	 * ����ֵΪtrue����ִ�У����������������
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//flag��ʾ�Ƿ��¼��Ĭ��δ��¼
		boolean flag = false;
		//�ж��Ƿ��������Ҫ����
		String servletPath = request.getServletPath();
		for (String s : IGNORE_URI) {
			if (servletPath.contains(s)) {
				//����Ҫ����
				flag = true;
				break;
			}
		}
		if (!flag) {
			//��������
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			if (admin == null) {
				//�û�δ��¼
				response.sendRedirect(request.getContextPath()+"/admin/login");
			} else {
				//�ѵ�¼���ж��Ƿ����
				long nowTime = new Date().getTime();
				long adminLoginTime = (long) request.getSession().getAttribute("adminLoginTime");
				if (nowTime - adminLoginTime >= 3600000) {	
					//����
					response.sendRedirect(request.getContextPath()+"/admin/login");
				} else {
					//δ���ڣ�ˢ�µ�¼ʱ��
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
