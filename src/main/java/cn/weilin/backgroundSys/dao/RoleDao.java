package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Role;

/**
 * 权限表 Dao类
 * @author Chen Weilin
 *
 */
public interface RoleDao {
	
	/**
	 * 根据adminId获取该管理员权限集合
	 * @param adminID
	 * @return 权限集合 如 1,34,65,77
	 */
	public String getRuleIdsByAdminId(@Param("adminID")int adminID);
	
	/**
	 * 获得所有角色集合
	 * @return
	 */
	public List<Role> getAllRole();
}
