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
	 * 登录页面展示
	 * @param model
	 * @return
	 * TODO status为禁用时的验证
	 */
	@RequestMapping(value = "/login")
	public String login(
			String adminPhone,
			String adminPassword,
			HttpServletRequest request,
			Model model) {
		//添加标题session
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		if (adminPhone == null && adminPassword == null) {
			return "login";
		}
		//登录验证
		Admin admin = adminService.login(adminPhone, adminPassword);
		if (admin == null) {
			//账号密码回填
			model.addAttribute("adminPhone", adminPhone);
			model.addAttribute("adminPassword", adminPassword);
			model.addAttribute("error", "账号或密码错误");
			return "login";
		} else {
			//将用户非敏感信息存入session,将登录时间存入session
			//默认过期时间为一小时
			request.getSession().setAttribute("admin", admin);
			request.getSession().setAttribute("adminLoginTime", new Date().getTime());
			return "redirect:/admin_module/index";
		}
	}
	
//	/**
//	 * 登录表单接口， 要求使用post方法
//	 * @return
//	 * TODO :错误信息反馈
//	 * TODO :登录权限写进session
//	 */
//	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
//	public String loginForm(
//			@RequestParam("adminPhone")String adminPhone, 
//			@RequestParam("adminPassword")String adminPassword,
//			HttpServletRequest request,
//			Model model) {
//		Admin admin = adminService.login(adminPhone, adminPassword);
//		if (admin == null) {
//			//账号密码回填
//			model.addAttribute("adminPhone", adminPhone);
//			model.addAttribute("adminPassword", adminPassword);
//			model.addAttribute("error", "账户或密码错误");
//			return "login";
//		} else {
//			//将用户非敏感信息存入session,将登录时间存入session
//			//默认过期时间为一小时
//			request.getSession().setAttribute("admin", admin);
//			request.getSession().setAttribute("adminLoginTime", new Date().getTime());
//			return "redirect:/user_module/index";
//		}
//	}
	
	/**
	 * 退出登录
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model){
		//清空session，网站标题不清空
		request.getSession().invalidate();
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		return "redirect:/admin/login";
	}
}
