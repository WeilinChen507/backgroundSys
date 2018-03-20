package cn.weilin.backgroundSys.service;

import org.springframework.stereotype.Service;

/**
 * 公共部分的逻辑处理
 * @author Chen Weilin
 */
public interface SettingService {

	/**
	 * 获得网站标题
	 * @return
	 */
	public String getWebTitle();
	
	/**
	 * 获得网站版权信息
	 * @return
	 */
	public String getCopyRight();
	
	/**
	 * 更新网站信息 包括标题和版权
	 * @return 成功返回true 失败返回false
	 */
	public boolean updateWebsiteSetting(String webTitle, String copyright);
	
}
