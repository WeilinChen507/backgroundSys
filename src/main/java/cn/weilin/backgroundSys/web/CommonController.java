package cn.weilin.backgroundSys.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.weilin.backgroundSys.service.SettingService;

/**
 * 公共部分的控制器
 * @author Chen Weilin
 *
 */
@Controller
public class CommonController {

	@Autowired
	SettingService settingService;
	
	/**
	 * 头部，加载网站名称标题
	 * @param model
	 */
	@RequestMapping("/title")
	public String head(HttpServletRequest request, Model model) {
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		model.addAttribute("webTitle", settingService.getWebTitle());
		return "common/title";
	}
	
	@RequestMapping("/nav")
	public String nav(HttpServletRequest request, Model model) {
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		model.addAttribute("webTitle", settingService.getWebTitle());
		return "common/nav";
	}
	
}
