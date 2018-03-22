package cn.weilin.backgroundSys.service;

import java.util.List;

import cn.weilin.backgroundSys.entity.Role;

/**
 * 角色管理 业务处理
 * @author Chen Weilin
 *
 */
public interface RoleService {

	/**
	 * 获得所有角色的集合
	 * @return
	 */
	public List<Role> getRoleList();
}
