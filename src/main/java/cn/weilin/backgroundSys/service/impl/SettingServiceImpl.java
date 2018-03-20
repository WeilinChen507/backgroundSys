package cn.weilin.backgroundSys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.dao.SettingDao;
import cn.weilin.backgroundSys.service.SettingService;

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
		//数据库影响条数 0为未修改 1为修改成功
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
