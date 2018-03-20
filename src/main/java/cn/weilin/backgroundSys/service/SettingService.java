package cn.weilin.backgroundSys.service;

import org.springframework.stereotype.Service;

/**
 * �������ֵ��߼�����
 * @author Chen Weilin
 */
public interface SettingService {

	/**
	 * �����վ����
	 * @return
	 */
	public String getWebTitle();
	
	/**
	 * �����վ��Ȩ��Ϣ
	 * @return
	 */
	public String getCopyRight();
	
	/**
	 * ������վ��Ϣ ��������Ͱ�Ȩ
	 * @return �ɹ�����true ʧ�ܷ���false
	 */
	public boolean updateWebsiteSetting(String webTitle, String copyright);
	
}
