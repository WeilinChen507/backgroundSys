package cn.weilin.backgroundSys.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.weilin.backgroundSys.service.SettingService;

@Controller
@RequestMapping(value = "/developer_module")
public class DeveloperModuleController {

	@Autowired
	SettingService settingService;
	
	/**
	 * 修改网站设置
	 * @param websiteTitle
	 * @param copyright
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/website_setting")
	public String websiteSetting(String websiteTitle, String copyright, HttpServletRequest request, Model model){
		//未修改前的网站信息
		model.addAttribute("websiteTitle", settingService.getWebTitle());
		model.addAttribute("copyright", settingService.getCopyRight());
		if (websiteTitle == null && copyright == null) {
			return "developer_module/website_setting";
		}
		boolean isOk = settingService.updateWebsiteSetting(websiteTitle, copyright);
		if (isOk) {
			//修改成功
			model.addAttribute("tips", "修改成功");
		} else {
			//修改失败
			model.addAttribute("tips", "修改失败，请稍后再试");
		}
		//修改后的信息填入
		model.addAttribute("websiteTitle", settingService.getWebTitle());
		model.addAttribute("copyright", settingService.getCopyRight());
		//更新网站标题
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		return "developer_module/website_setting";
	}
}
