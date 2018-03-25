package cn.weilin.backgroundSys.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.weilin.backgroundSys.service.SettingService;

/**
 * 公共模块
 * @author Chen Weilin
 * 现已删除 仅用作测试 最后删除
 */
@Controller
public class CommonController {

	@Autowired
	SettingService settingService;
	

	@RequestMapping("/title")
	public String head(HttpServletRequest request, Model model) {
		//request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		//model.addAttribute("webTitle", settingService.getWebTitle());
		System.out.println("����headController");
		return "common/title";
	}
	
	@RequestMapping("/nav")
	public String nav(HttpServletRequest request, Model model) {
		//request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		//model.addAttribute("webTitle", settingService.getWebTitle());
		System.out.println("����navController");

		return "common/nav";
	}
	
}
