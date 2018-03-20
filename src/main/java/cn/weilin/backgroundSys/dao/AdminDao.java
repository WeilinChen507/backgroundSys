package cn.weilin.backgroundSys.dao;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Admin;

/**
 * 管理员列表dao
 * @author Chen Weilin
 *
 */
public interface AdminDao {

	/**
	 * 根据账号密码判断是否有该
	 * @param adminPhone
	 * @param adminPassword
	 * @return Admin实体类
	 */
	Admin login(@Param("adminPhone")String adminPhone, @Param("adminPassword")String adminPassword);
	
	
	
}
