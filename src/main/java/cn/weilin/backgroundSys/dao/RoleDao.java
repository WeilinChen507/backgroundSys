package cn.weilin.backgroundSys.dao;

import org.apache.ibatis.annotations.Param;

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
	
	
}
