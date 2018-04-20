package cn.weilin.backgroundSys.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.tags.EditorAwareTag;

import cn.weilin.backgroundSys.dto.Pagination;
import cn.weilin.backgroundSys.dto.RoleForm;
import cn.weilin.backgroundSys.dto.RuleForm;
import cn.weilin.backgroundSys.entity.Admin;
import cn.weilin.backgroundSys.entity.Role;
import cn.weilin.backgroundSys.entity.Rule;
import cn.weilin.backgroundSys.exception.BaseException;
import cn.weilin.backgroundSys.exception.InputWrongFormatException;
import cn.weilin.backgroundSys.service.AdminService;
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
	private SettingService settingService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RuleService ruleService;
	
	@Autowired
	private AdminService adminService;
	
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
	 * 添加角色页面
	 * @return
	 */
	@RequestMapping(value = "/add_role",
			method = RequestMethod.GET)
	public String addRole(HttpServletRequest request) {
		//渲染所有权限
		List<Rule> list = ruleService.getAllRule();
		request.setAttribute("ruleList", list);
		return "developer_module/add_role";
	}
	
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping(value = "/add_role",
			method = RequestMethod.POST)
	public String addRole(@ModelAttribute RoleForm roleForm,HttpServletRequest request) {
		try {
			//渲染所有权限
			List<Rule> list = ruleService.getAllRule();
			request.setAttribute("ruleList", list);
			roleService.addRole(roleForm);
			//抛出异常时提示信息回填并提示错误信息
		} catch (InputWrongFormatException e) {
			request.setAttribute("tips", e.getMessage());
			request.setAttribute("roleForm", roleForm);
			return "developer_module/add_role";
		} catch (BaseException e) {
			request.setAttribute("tips", e.getMessage());
			request.setAttribute("roleForm", roleForm);
			return "developer_module/add_role";
		} catch (Exception e) {
			//inner error
			request.setAttribute("tips", "系统繁忙，请稍候再试");
			request.setAttribute("roleForm", roleForm);
			return "developer_module/add_role";
		}
		return "developer_module/add_role";
	}
	
	/**
	 * 删除角色
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/delete_role/{id}",
			method = RequestMethod.GET)
	public String deleteRole(@PathVariable("id")int id, Model model) {
		try {
			roleService.deleteRole(id);
		} catch (Exception e) {
			model.addAttribute("list", roleService.getRoleList());
			//TODO 错误提示
			return "developer_module/role_list";
		}
		model.addAttribute("list", roleService.getRoleList());
		return "developer_module/role_list";
	}
	
	/**
	 * 编辑角色页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit_role/{id}",
			method = RequestMethod.GET)
	public String editRole(@PathVariable("id")int id, Model model) {
		try {
			//信息填入
			List<Rule> list = ruleService.getAllRule();
			model.addAttribute("ruleList", list);
			RoleForm roleForm = new RoleForm(roleService.getRoleById(id));
			model.addAttribute("roleForm", roleForm);
		} catch (Exception e) {
			model.addAttribute("tips", "系统繁忙，请刷新重新加载");
			return "developer_module/edit_role";
		}
		return "developer_module/edit_role";
	}
	
	/**
	 * 编辑角色表单处理
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit_role",
			method = RequestMethod.POST)
	public String editRole(@ModelAttribute RoleForm roleForm, Model model) {
		try {
			List<Rule> list = ruleService.getAllRule();
			model.addAttribute("ruleList", list);
			//信息回填
			model.addAttribute("roleForm", roleForm);
			roleService.editRole(roleForm);
		} catch (InputWrongFormatException e) {
			model.addAttribute("tips", e.getMessage());
			return "developer_module/edit_role";
		} catch (BaseException e) {
			model.addAttribute("tips", e.getMessage());
			return "developer_module/edit_role";
		} catch (Exception e) {
			//inner
			model.addAttribute("tips", "系统繁忙，请稍候再试");
			return "developer_module/edit_role";
		}
		model.addAttribute("tips", "修改成功");
		return "developer_module/edit_role";
	}
	
	/**
	 *  权限列表页 首页
	 *  每一页对于一个模块及其子模块
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/rule_list",
			method = RequestMethod.GET)
	public String ruleList(Model model) {
		//默认从分页的第一页开始浏览
		String page = "1";
		List<Rule> list = ruleService.getAllRuleByPage(page);
		model.addAttribute("list", list);
		//用于分页的变量
		Pagination pagination = ruleService.getPaginationOfRuleList(page);
		model.addAttribute("pagination", pagination);
		return "developer_module/rule_list";
	}
	/**
	 * 权限列表页 分页查询
	 * 每一页对于一个模块及其子模块
	 * @param page 页数从1开始 默认为0
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/rule_list/{page}",
			method = RequestMethod.GET)
	public String ruleList(@PathVariable("page") String page,
			Model model) {
		List<Rule> list = ruleService.getAllRuleByPage(page);
		model.addAttribute("list", list);
		//用于分页的变量
		Pagination pagination = ruleService.getPaginationOfRuleList(page);
		model.addAttribute("pagination", pagination);
		return "developer_module/rule_list";
	}
	
	/**
	 * 添加权限页面
	 * @return
	 */
	@RequestMapping(value = "/add_rule",
			method = RequestMethod.GET)
	public String addRule(Model model) {
		model.addAttribute("ruleList", ruleService.getAllRule());
		return "developer_module/add_rule";
	}
	
	/**
	 * 添加权限操作
	 * @param ruleForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add_rule",
			method = RequestMethod.POST)
	public String addRule(@ModelAttribute RuleForm ruleForm,
			HttpServletRequest request,
			Model model) {
		model.addAttribute("ruleList", ruleService.getAllRule());
		try {
			ruleService.addRule(ruleForm);
		} catch (InputWrongFormatException e) {
			model.addAttribute("tips", e.getMessage());
			return "developer_module/add_rule";
		} catch (BaseException e) {
			model.addAttribute("tips", e.getMessage());
			return "developer_module/add_rule";
		}
		model.addAttribute("tips", "添加成功");
		//更新左侧导航栏
		//左侧导航栏信息放在admin中，只需要更新admin
		Admin adminBefore = (Admin)request.getSession().getAttribute("admin");	
		request.getSession().setAttribute("admin", adminService.GetAdminById(adminBefore.getId()));
		return "developer_module/add_rule";
	}
	
	/**
	 * 删除权限操作
	 * @return
	 */
	@RequestMapping(value = "/delete_rule/{rule_id}",
			method = RequestMethod.GET)
	public String deleteRule(@PathVariable("rule_id")int ruleId, HttpServletRequest request){
		try {
			ruleService.deleteRule(ruleId);
		} catch (BaseException e) {
			//错误提示
			//TODO
			return "redirect:/developer_module/rule_list";
		}
		//更新左侧导航栏
		//左侧导航栏信息放在admin中，只需要更新admin
		Admin adminBefore = (Admin)request.getSession().getAttribute("admin");	
		request.getSession().setAttribute("admin", adminService.GetAdminById(adminBefore.getId()));
		String retUrl = request.getHeader("Referer");   
		return "redirect:" + retUrl;
	}
	
	/**
	 * 页面展示，信息回填
	 * @param ruleId
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/edit_rule/{rule_id}",
			method = RequestMethod.GET)
	public String editRule(@PathVariable("rule_id")int ruleId, HttpServletRequest request) {
		//填入该id的rule信息
		try {
			request.setAttribute("ruleList", ruleService.getAllRule());
			Rule rule = ruleService.getRuleById(ruleId);
			RuleForm ruleForm = new RuleForm(rule);
			request.setAttribute("ruleForm", ruleForm);
			request.setAttribute("rule_id", ruleId);
		} catch (Exception e) {
			//内部错误,页面不跳转
			String retUrl = request.getHeader("Referer");   
			return "redirect:" + retUrl;
		}
		return "developer_module/edit_rule";
	}
	
	/**
	 * 修改rule信息表单提交
	 * @param ruleForm
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/edit_rule",
			method = RequestMethod.POST)
	public String editRule(@ModelAttribute RuleForm ruleForm ,HttpServletRequest request) {
		//修改该id的rule信息
		try {
			ruleService.editRule(ruleForm);
		} catch (InputWrongFormatException e) {
			request.setAttribute("ruleList", ruleService.getAllRule());
			request.setAttribute("tips", e.getMessage());
			request.setAttribute("ruleForm", ruleForm);
			return "developer_module/edit_rule";
		} catch (BaseException e) {
			request.setAttribute("ruleList", ruleService.getAllRule());
			request.setAttribute("tips", e.getMessage());
			request.setAttribute("ruleForm", ruleForm);
			return "developer_module/edit_rule";
		} catch (Exception e) {
			//未知错误
			request.setAttribute("ruleList", ruleService.getAllRule());
			request.setAttribute("tips", "系统繁忙，请稍候再试");
			request.setAttribute("ruleForm", ruleForm);
			return "developer_module/edit_rule";
		}
		//更新左侧导航栏
		//左侧导航栏信息放在admin中，只需要更新admin
		Admin adminBefore = (Admin)request.getSession().getAttribute("admin");	
		request.getSession().setAttribute("admin", adminService.GetAdminById(adminBefore.getId()));
		return "redirect:/developer_module/rule_list";
	}
}
