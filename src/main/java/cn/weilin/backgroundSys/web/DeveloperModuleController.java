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
	 * �޸���վ����
	 * @param websiteTitle
	 * @param copyright
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/website_setting")
	public String websiteSetting(String websiteTitle, String copyright, HttpServletRequest request, Model model){
		//δ�޸�ǰ����վ��Ϣ
		model.addAttribute("websiteTitle", settingService.getWebTitle());
		model.addAttribute("copyright", settingService.getCopyRight());
		if (websiteTitle == null && copyright == null) {
			return "developer_module/website_setting";
		}
		boolean isOk = settingService.updateWebsiteSetting(websiteTitle, copyright);
		if (isOk) {
			//�޸ĳɹ�
			model.addAttribute("tips", "�޸ĳɹ�");
		} else {
			//�޸�ʧ��
			model.addAttribute("tips", "�޸�ʧ�ܣ����Ժ�����");
		}
		//�޸ĺ����Ϣ����
		model.addAttribute("websiteTitle", settingService.getWebTitle());
		model.addAttribute("copyright", settingService.getCopyRight());
		//������վ����
		request.getSession().setAttribute("webTitle", settingService.getWebTitle());
		return "developer_module/website_setting";
	}
}
