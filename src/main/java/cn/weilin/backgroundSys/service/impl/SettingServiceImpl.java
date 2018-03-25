package cn.weilin.backgroundSys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.dao.SettingDao;
import cn.weilin.backgroundSys.service.SettingService;

/**
 * 网站设置业务逻辑实现类
 * @author Chen Weilin
 *
 */
@Service
public class SettingServiceImpl implements SettingService {

	@Autowired
	SettingDao settingDao;
	
	@Override
	public String getWebTitle() {
		String webTitle = settingDao.getWebTitle();
		return webTitle;
	}
	

	@Override
	public String getCopyRight() {
		String copyRight = settingDao.getCopyright();
		return copyRight;
	}

	@Override
	public boolean updateWebsiteSetting(String webTitle, String copyright) {
		boolean hasTitle =  !(null == webTitle || "".equals(webTitle));
		boolean hasCopyright = !(null == copyright || "".equals(copyright));
		//是否更新成功 0为失败
		int influencedNum = 0;
		if (hasTitle && hasCopyright) {
			influencedNum = settingDao.updateWebSetting(webTitle, copyright);
		} else if (hasTitle) {
			influencedNum = settingDao.updateWebTitle(webTitle);
		} else if (hasCopyright) {
			influencedNum = settingDao.updateCopyright(copyright);
		}
		return influencedNum == 1? true : false;
	}


}
