package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Admin;

/**
 * 管理员Dao
 * @author Chen Weilin
 *
 */
public interface AdminDao {

	/**
	 * 登录
	 * @param adminPhone
	 * @param adminPassword
	 * @return 成功返回Admin实体类，失败返回null
	 */
	Admin login(@Param("adminPhone")String adminPhone, @Param("adminPassword")String adminPassword);
	
	/**
	 * 返回所有管理员信息，包含角色
	 * @return
	 */
	List<Admin> getAllAdminWithRole();
}
