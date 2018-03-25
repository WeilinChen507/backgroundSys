package cn.weilin.backgroundSys.service;

import org.springframework.stereotype.Service;

/**
 * 网站信息操作业务
 * @author Chen Weilin
 */
public interface SettingService {

	/**
	 * 获得网站标题
	 * @return
	 */
	public String getWebTitle();
	
	/**
	 * 获得网站版权
	 * @return
	 */
	public String getCopyRight();
	
	/**
	 * 更新网站信息
	 * @return 更新是否成功
	 */
	public boolean updateWebsiteSetting(String webTitle, String copyright);
	
}
