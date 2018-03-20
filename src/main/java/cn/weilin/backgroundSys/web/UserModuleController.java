package cn.weilin.backgroundSys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.weilin.backgroundSys.service.SettingService;

@Controller
@RequestMapping(value = "/user_module")
public class UserModuleController {

	@Autowired
	SettingService settingService;
	
	/**
	 * �û���ҳ
	 * url /user_module/index
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		//����վ��Ȩ��Ϣд��
		model.addAttribute("copyright", settingService.getCopyRight());
		return "user_module/index";
	}
}
