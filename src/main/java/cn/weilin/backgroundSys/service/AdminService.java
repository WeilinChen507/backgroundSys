package cn.weilin.backgroundSys.service;

import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.entity.Admin;

/**
 * �������Ա��ص�ҵ���߼�
 * @author Chen Weilin
 */
public interface AdminService {

	/**
	 * ��¼�ӿ�
	 * @param adminPhone
	 * @param adminPassword
	 * @return ��֤�ɹ����ع���Աʵ�壬ʧ���򷵻�null
	 */
	Admin login(String adminPhone, String adminPassword);
	
	
}
