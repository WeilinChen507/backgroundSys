package cn.weilin.backgroundSys.web;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.weilin.backgroundSys.dto.AdminForm;
import cn.weilin.backgroundSys.entity.Admin;
import cn.weilin.backgroundSys.entity.Role;
import cn.weilin.backgroundSys.exception.BaseException;
import cn.weilin.backgroundSys.exception.InputWrongFormatException;
import cn.weilin.backgroundSys.service.AdminService;
import cn.weilin.backgroundSys.service.RoleService;
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
	
	@Autowired
	RoleService roleService;
	
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
	
	/**
	 * 添加管理员页面展示
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add_admin", method = RequestMethod.GET)
	public String addAdmin(Model model) {
		//加载所有角色提供选择
		try {
			List<Role> list = roleService.getRoleList();
			model.addAttribute("roleList", list);
		} catch (Exception e) {
			// inner error
			model.addAttribute("tips", "系统繁忙，请刷新页面重新加载");
		}
		return "admin_module/add_admin";
	}
	
	/**
	 * 添加管理员操作
	 * @param adminForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add_admin", method = RequestMethod.POST)
	public String addAdmin(@ModelAttribute AdminForm adminForm,
			Model model) {
		try {
			//加载所有角色提供选择
			List<Role> list = roleService.getRoleList();
			model.addAttribute("roleList", list);
			model.addAttribute("adminForm", adminForm);
		} catch (Exception e) {
			// inner error
			model.addAttribute("tips", "系统繁忙，请刷新页面重新加载");
			return "admin_module/add_admin";
		}
		try {
			adminService.addAdminByForm(adminForm);
		} catch (InputWrongFormatException e) {
			model.addAttribute("tips", e.getMessage());
			return "admin_module/add_admin";
		} catch (BaseException e) {
			model.addAttribute("tips", e.getMessage());
			return "admin_module/add_admin";
		} catch (Exception e) {
			//inner error
			model.addAttribute("tips", "系统繁忙，请稍候再试");
			return "admin_module/add_admin";
		}
		return "redirect:admin_list";
	}
	
	/**
	 * 删除管理员操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete_admin/{id}",
			method = RequestMethod.GET)
	public String deleteAdmin(@PathVariable("id")int id) {
		try {
			adminService.deleteById(id);
			return "redirect:/admin_module/admin_list";
		} catch (Exception e) {
			return "redirect:/admin_module/admin_list";
		}
	}
	
	/**
	 * 编辑管理员页面展示
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit_admin/{id}",
			method = RequestMethod.GET)
	public String editAdmin(@PathVariable("id")int id, Model model) {
		try {
			model.addAttribute("roleList", roleService.getRoleList());
			Admin admin = adminService.GetAdminById(id);
			AdminForm adminForm = new AdminForm(admin.getId(), admin.getAdminAccount(), 
					admin.getAdminFullname(), admin.getAdminPhone(), (int)admin.getStatus(), admin.getRole().getId());
			model.addAttribute("adminForm", adminForm);
			return "admin_module/edit_admin";
		} catch (Exception e) {
			model.addAttribute("tips", "页面加载错误，请刷新重试");
			return "admin_module/edit_admin";
		}
	}
	
	/**
	 * 编辑表单提交
	 * @param adminForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit_admin",
			method = RequestMethod.POST)
	public String editAdmin(@ModelAttribute AdminForm adminForm, Model model) {
		try {
			model.addAttribute("roleList", roleService.getRoleList());
			adminService.editAdminByForm(adminForm);
			model.addAttribute("adminForm", adminForm);
		} catch (InputWrongFormatException e) {
			model.addAttribute("tips", e.getMessage());
			return "admin_module/edit_admin";
		} catch (BaseException e) {
			model.addAttribute("tips", e.getMessage());
			return "admin_module/edit_admin";
		} catch (Exception e) {
			model.addAttribute("tips", "系统繁忙，请稍后再试");
			return "admin_module/edit_admin";
		}
		return "redirect:/admin_module/admin_list";
	}
	
}





