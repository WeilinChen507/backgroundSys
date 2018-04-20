package cn.weilin.backgroundSys.service;

import java.util.List;

import cn.weilin.backgroundSys.dto.RoleForm;
import cn.weilin.backgroundSys.entity.Role;
import cn.weilin.backgroundSys.exception.BaseException;
import cn.weilin.backgroundSys.exception.InputWrongFormatException;

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
	
	/**
	 * 根据id查询role
	 * @return
	 */
	public Role getRoleById(int id);
	
	/**
	 * 添加角色
	 * @param form
	 * @throws InputWrongFormatException
	 * @throws BaseException
	 */
	public void addRole(RoleForm form) throws InputWrongFormatException, BaseException;
	
	/**
	 * 更新角色
	 * @param form
	 * @throws InputWrongFormatException
	 * @throws BaseException
	 */
	public void editRole(RoleForm form) throws InputWrongFormatException, BaseException;
	
	/**
	 * 删除角色
	 * @param id
	 * @throws BaseException 删除失败时抛出
	 */
	public void deleteRole(int id) throws BaseException;
}
