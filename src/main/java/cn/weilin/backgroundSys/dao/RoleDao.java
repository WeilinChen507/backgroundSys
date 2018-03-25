package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Role;

/**
 * 角色Dao
 * @author Chen Weilin
 *
 */
public interface RoleDao {
	
	/**
	 * 根绝adminId查询该管理员的权限ID集合
	 * @param adminID
	 * @return 权限ID集合 如：1,34,65,77
	 */
	public String getRuleIdsByAdminId(@Param("adminID")int adminID);
	
	/**
	 * 返回所有角色类型
	 * @return
	 */
	public List<Role> getAllRole();
}
