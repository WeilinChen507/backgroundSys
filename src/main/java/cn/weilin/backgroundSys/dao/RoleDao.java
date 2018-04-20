package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.dto.RoleForm;
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
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Role getRoleById(@Param("id")int id);
	
	/**
	 * 根据名称查询
	 * @param roleName
	 * @return
	 */
	public Role getRoleByName(@Param("roleName") String roleName);
	
	/**
	 * 根据roleForm添加
	 * @param RoleForm
	 * @return 影响条数
	 */
	public int addRoleByRole(@Param("role")Role role, @Param("time")int createTime);
	
	/**
	 * 根据roleFform更新
	 * @param RoleForm
	 * @return 影响条数
	 */
	public int updateRoleByRole(@Param("role")Role role, @Param("time")int updateTime);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return 影响条数
	 */
	public int deleteRoleById(int id);
}
