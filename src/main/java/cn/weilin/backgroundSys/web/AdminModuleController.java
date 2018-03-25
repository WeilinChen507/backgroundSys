package cn.weilin.backgroundSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.weilin.backgroundSys.service.AdminService;
import cn.weilin.backgroundSys.service.SettingService;

/**
 * 管理员模块 控制器
 * @author Chen Weilin
 *
 */
@Controller
@RequestMapping(value = "/admin_module")
public class AdminModuleController {

	@Autowired
	SettingService settingService;
	
	@Autowired
	AdminService adminService;
	
	/**
	 * 首页
	 * url /user_module/index
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		//网站版权写入attribute
		model.addAttribute("copyright", settingService.getCopyRight());
		return "admin_module/index";
	}
	
	/**
	 * 管理员列表页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin_list", method = RequestMethod.GET)
	public String adminList(Model model) {
		model.addAttribute("list", adminService.getAdminList());
		return "admin_module/admin_list";
	}
}
