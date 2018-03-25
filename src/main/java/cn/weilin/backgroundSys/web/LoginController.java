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

/**
 * 登录控制器 负责登录 退登
 * @author Chen Weilin
 *
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	SettingService settingService;
	
	/**
	 * 登录页面
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
		//写入网站标题进session
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		if (adminPhone == null && adminPassword == null) {
			return "login";
		}
		//登录  判断是否登录成功֤
		Admin admin = adminService.login(adminPhone, adminPassword);
		if (admin == null) {
			//失败 账号密码回填
			model.addAttribute("adminPhone", adminPhone);
			model.addAttribute("adminPassword", adminPassword);
			model.addAttribute("error", "手机或密码错误");
			return "login";
		} else {
			//登录成功
			//把非敏感信息写入session并跳转至首页
			request.getSession().setAttribute("admin", admin);
			request.getSession().setAttribute("adminLoginTime", new Date().getTime());
			return "redirect:/admin_module/index";
		}
	}

	/**
	 * 退出登录
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model){
		//清空session
		request.getSession().invalidate();
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		return "redirect:/admin/login";
	}
}
