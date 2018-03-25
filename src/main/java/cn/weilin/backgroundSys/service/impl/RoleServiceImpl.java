package cn.weilin.backgroundSys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.dao.RoleDao;
import cn.weilin.backgroundSys.entity.Role;
import cn.weilin.backgroundSys.service.RoleService;

/**
 * 角色业务逻辑处理实现类
 * @author Chen Weilin
 *
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> getRoleList() {
		List<Role> list = roleDao.getAllRole();
		return list;
	}

}
