package cn.weilin.backgroundSys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.dao.RoleDao;
import cn.weilin.backgroundSys.dto.RoleForm;
import cn.weilin.backgroundSys.entity.Role;
import cn.weilin.backgroundSys.exception.BaseException;
import cn.weilin.backgroundSys.exception.InputWrongFormatException;
import cn.weilin.backgroundSys.service.RoleService;

/**
 * 角色业务逻辑处理实现类
 * @author Chen Weilin
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<Role> getRoleList() {
		List<Role> list = roleDao.getAllRole();
		return list;
	}
	
	@Override
	public Role getRoleById(int id) {
		Role role = roleDao.getRoleById(id);
		return role;
	}

	@Override
	public void addRole(RoleForm form) throws InputWrongFormatException, BaseException {
		try {
			checkRoleForm(form);
			if (roleDao.getRoleByName(form.getRoleName()) != null ) {
				throw new InputWrongFormatException("角色名称已存在");
			}
		} catch (InputWrongFormatException e) {
			throw e;
		} catch (Exception e) {
			throw new BaseException("系统繁忙，请稍候再试");
		}
		Role role = new Role(form.getRoleName(), formIdsToString(form.getRuleIds()), form.getStatus(), form.getRemark());
		try {
			if (roleDao.addRoleByRole(role, (int)(new Date().getTime()/1000)) == 0) {
				throw new BaseException("系统繁忙，请稍候再试");
			}
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			//inner error
			throw new BaseException("系统繁忙，请稍候再试");
		}
	}

	@Override
	public void editRole(RoleForm form) throws InputWrongFormatException, BaseException {
		//表单检查
		if (form.getId() == null) {
			throw new InputWrongFormatException("必填字段不能为空");
		}
		try {
			checkRoleForm(form);
		} catch (InputWrongFormatException e) {
			throw e;
		}
		Role role = new Role(form.getId(),form.getRoleName(), formIdsToString(form.getRuleIds()), form.getStatus(), form.getRemark());
		try {
			if (roleDao.updateRoleByRole(role, (int)(new Date().getTime()/1000)) == 0) {
				throw new BaseException("系统繁忙，请稍候再试");
			}
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			//inner error
			throw new BaseException("系统繁忙，请稍候再试");
		}
		
	}

	@Override
	public void deleteRole(int id) throws BaseException {
		try {
			if (roleDao.deleteRoleById(id) == 0) {
				throw new BaseException("系统繁忙，请稍候再试");
			}
		} catch (BaseException e) {
			throw e;
		} catch (Exception e) {
			// inner error
			throw new BaseException("系统繁忙，请稍候再试");
		}
		
	}
	
	/**
	 * 检查表单信息，id不检查
	 * @param form
	 * @throws InputWrongFormatException
	 * @throws BaseException
	 */
	private void checkRoleForm(RoleForm form) throws InputWrongFormatException{
		if (form.getRemark() == null || form.getRoleName() == null ||
				form.getRuleIds() == null || form.getStatus() == null) {
			throw new InputWrongFormatException("必填字段不能为空");
		}
		if (form.getStatus() != 1 && form.getStatus() != 2) {
			throw new InputWrongFormatException("状态错误，请调整格式");
		}
	}
	
	/**
	 * ids字符串数组拼接成符合格式ids
	 * @param ids
	 * @return
	 */
	private String formIdsToString(String[] ids) {
		StringBuilder idCo = new StringBuilder();	//此处不存在线程安全问题，可能存在多个管理员同时操作角色
		//最后一个id后面不需要,
		int length = ids.length;
		for (int i = 0; i < length-1; i++) {
			idCo.append(ids[i] + ",");
		}
		idCo.append(ids[length-1]);
		return idCo.toString();
	}


}
