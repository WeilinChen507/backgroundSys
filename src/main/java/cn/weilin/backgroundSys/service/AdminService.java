package cn.weilin.backgroundSys.service;

import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.entity.Admin;

/**
 * 处理管理员相关的业务逻辑
 * @author Chen Weilin
 */
public interface AdminService {

	/**
	 * 登录接口
	 * @param adminPhone
	 * @param adminPassword
	 * @return 验证成功返回管理员实体，失败则返回null
	 */
	Admin login(String adminPhone, String adminPassword);
	
	
}
