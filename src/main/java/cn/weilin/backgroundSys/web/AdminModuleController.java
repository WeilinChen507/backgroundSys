package cn.weilin.backgroundSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.weilin.backgroundSys.service.AdminService;
import cn.weilin.backgroundSys.service.SettingService;

@Controller
@RequestMapping(value = "/admin_module")
public class AdminModuleController {

	@Autowired
	SettingService settingService;
	
	@Autowired
	AdminService adminService;
	
	/**
	 * 用户首页
	 * url /user_module/index
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		//将网站版权信息写入
		model.addAttribute("copyright", settingService.getCopyRight());
		return "admin_module/index";
	}
	
	/**
	 * 管理员管理 管理员列表页
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin_list", method = RequestMethod.GET)
	public String adminList(Model model) {
		model.addAttribute("list", adminService.getAdminList());
		return "admin_module/admin_list";
	}
}
