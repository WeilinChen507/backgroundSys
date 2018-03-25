package cn.weilin.backgroundSys.service;

import java.util.List;

import cn.weilin.backgroundSys.entity.Role;

/**
 * 角色操作业务
 * @author Chen Weilin
 *
 */
public interface RoleService {

	/**
	 * 获得所有角色集合
	 * @return
	 */
	public List<Role> getRoleList();
}
