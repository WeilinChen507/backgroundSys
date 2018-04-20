package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.dto.AdminForm;
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
	public Admin login(@Param("adminPhone")String adminPhone, @Param("adminPassword")String adminPassword);
	
	/**
	 * 返回所有管理员信息，包含角色
	 * @return
	 */
	public List<Admin> getAllAdminWithRole();
	
	/**
	 * 通过id获取admin
	 * @param id
	 * @return
	 */
	public Admin getAdminWithRoleById(@Param("id") int id);
	
	/**
	 * 添加admin
	 * @param admin
	 * @param createTime
	 * @return 自增id
	 */
	public int addAdminByAdminForm(AdminForm admin);
	
	/**
	 * 删除admin
	 * @param id
	 * @return
	 */
	public int deleteAdminById(@Param("id")int id);
	
	/**
	 * 更新
	 * @param admin
	 * @return
	 */
	public int updateByAdminForm(AdminForm admin);
}
