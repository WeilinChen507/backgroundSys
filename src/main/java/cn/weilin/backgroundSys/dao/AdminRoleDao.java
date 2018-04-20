package cn.weilin.backgroundSys.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 定义了admin和role的one-many的关系表
 * @author Chen Weilin
 *
 */
public interface AdminRoleDao {

	/**
	 * 
	 * @param adminId
	 * @param roleId
	 * @param createTime
	 * @return 返回影响条数
	 */
	public int addMapping(@Param("adminId")int adminId, @Param("roleId")int roleId);
	
	/**
	 * 
	 * @param adminId
	 * @param roleId
	 * @param updateTime
	 * @return 返回影响条数
	 */
	public int updateMapping(@Param("adminId")int adminId, @Param("roleId")int roleId);
	
	/**
	 * 
	 * @param adminId
	 * @return 影响条数
	 */
	public int deleteMappingByAdminId(@Param("adminId")int adminId);
	
	/**
	 * id
	 * @param id
	 * @return 影响条数
	 */
	public int deleteMappingById(@Param("id")int id);
}
