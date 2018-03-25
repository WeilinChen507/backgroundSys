package cn.weilin.backgroundSys.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.weilin.backgroundSys.entity.Rule;
import cn.weilin.backgroundSys.service.RoleService;
import cn.weilin.backgroundSys.service.RuleService;
import cn.weilin.backgroundSys.service.SettingService;

/**
 * 开发者模块 控制器
 * @author Chen Weilin
 *
 */
@Controller
@RequestMapping(value = "/developer_module")
public class DeveloperModuleController {

	@Autowired
	SettingService settingService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	RuleService ruleService;
	
	
	/**
	 * 更新网站设置 页面
	 * @param websiteTitle
	 * @param copyright
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/website_setting")
	public String websiteSetting(String websiteTitle, String copyright, HttpServletRequest request, Model model){
		//填入已设置的信息
		model.addAttribute("websiteTitle", settingService.getWebTitle());
		model.addAttribute("copyright", settingService.getCopyRight());
		if (websiteTitle == null && copyright == null) {
			return "developer_module/website_setting";
		}
		boolean isOk = settingService.updateWebsiteSetting(websiteTitle, copyright);
		if (isOk) {
			//更新成功
			model.addAttribute("tips", "更新成功");
		} else {
			//失败
			model.addAttribute("tips", "更新失败，请稍后再试");
		}
		//回填信息
		model.addAttribute("websiteTitle", settingService.getWebTitle());
		model.addAttribute("copyright", settingService.getCopyRight());
		//session中的网站标题更新
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		return "developer_module/website_setting";
	}
	
	
	/**
	 * 角色列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/role_list")
	public String roleList(Model model) {
		model.addAttribute("list", roleService.getRoleList());
		return "developer_module/role_list";
	}
	
	/**
	 * 权限列表页 分页查询
	 * 每一页对于一个模块及其子模块
	 * @param page 页数从1开始 默认为0
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/rule_list",
			method = RequestMethod.GET)
	public String ruleList(String page,
			Model model) {
		List<Rule> list = ruleService.getAllRuleByPage(page);
		model.addAttribute("list", list);
		return "developer_module/rule_list";
	}
	
	
}
