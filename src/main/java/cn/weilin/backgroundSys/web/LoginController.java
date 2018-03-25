package cn.weilin.backgroundSys.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.weilin.backgroundSys.entity.Admin;
import cn.weilin.backgroundSys.service.AdminService;
import cn.weilin.backgroundSys.service.SettingService;


@Controller
@RequestMapping("/admin")
public class LoginController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	SettingService settingService;
	
	/**
	 * ��¼ҳ��չʾ
	 * @param model
	 * @return
	 * TODO statusΪ����ʱ����֤
	 */
	@RequestMapping(value = "/login")
	public String login(
			String adminPhone,
			String adminPassword,
			HttpServletRequest request,
			Model model) {
		//��ӱ���session
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		if (adminPhone == null && adminPassword == null) {
			return "login";
		}
		//��¼��֤
		Admin admin = adminService.login(adminPhone, adminPassword);
		if (admin == null) {
			//�˺��������
			model.addAttribute("adminPhone", adminPhone);
			model.addAttribute("adminPassword", adminPassword);
			model.addAttribute("error", "手机或密码错误");
			return "login";
		} else {
			//���û���������Ϣ����session,����¼ʱ�����session
			//Ĭ�Ϲ���ʱ��ΪһСʱ
			request.getSession().setAttribute("admin", admin);
			request.getSession().setAttribute("adminLoginTime", new Date().getTime());
			return "redirect:/admin_module/index";
		}
	}
	
//	/**
//	 * ��¼���ӿڣ� Ҫ��ʹ��post����
//	 * @return
//	 * TODO :������Ϣ����
//	 * TODO :��¼Ȩ��д��session
//	 */
//	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
//	public String loginForm(
//			@RequestParam("adminPhone")String adminPhone, 
//			@RequestParam("adminPassword")String adminPassword,
//			HttpServletRequest request,
//			Model model) {
//		Admin admin = adminService.login(adminPhone, adminPassword);
//		if (admin == null) {
//			//�˺��������
//			model.addAttribute("adminPhone", adminPhone);
//			model.addAttribute("adminPassword", adminPassword);
//			model.addAttribute("error", "�˻����������");
//			return "login";
//		} else {
//			//���û���������Ϣ����session,����¼ʱ�����session
//			//Ĭ�Ϲ���ʱ��ΪһСʱ
//			request.getSession().setAttribute("admin", admin);
//			request.getSession().setAttribute("adminLoginTime", new Date().getTime());
//			return "redirect:/user_module/index";
//		}
//	}
	
	/**
	 * �˳���¼
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model){
		//���session����վ���ⲻ���
		request.getSession().invalidate();
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		return "redirect:/admin/login";
	}
}
