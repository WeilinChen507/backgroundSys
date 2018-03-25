package cn.weilin.backgroundSys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.entity.Admin;

/**
 * 管理员业务接口
 * @author Chen Weilin
 */
public interface AdminService {

	/**
	 * 登录 成功则返回admin对象 否则null
	 * @param adminPhone
	 * @param adminPassword
	 * @return 
	 */
	public Admin login(String adminPhone, String adminPassword);
	
	/**
	 * 获得所有管理员 供超管用
	 * @return 所有管理员的集合
	 */
	public List<Admin> getAdminList();
}
