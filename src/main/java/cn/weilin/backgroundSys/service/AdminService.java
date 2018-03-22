package cn.weilin.backgroundSys.service;

import java.util.List;

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
	public Admin login(String adminPhone, String adminPassword);
	
	/**
	 * 获得所有管理员信息 包含管理员角色
	 * @return
	 */
	public List<Admin> getAdminList();
}
