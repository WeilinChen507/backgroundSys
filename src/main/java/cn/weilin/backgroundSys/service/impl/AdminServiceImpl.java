package cn.weilin.backgroundSys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.Util.MyStringUtils;
import cn.weilin.backgroundSys.dao.AdminDao;
import cn.weilin.backgroundSys.dao.RoleDao;
import cn.weilin.backgroundSys.dao.RuleDao;
import cn.weilin.backgroundSys.entity.Admin;
import cn.weilin.backgroundSys.service.AdminService;

/**
 * 
 * @author Chen Weilin
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private RuleDao ruleDao;
	
	/**
	 * 登录接口的实现操作
	 */
	public Admin login(String adminPhone, String adminPassword) {
		//数据库中储存的是加密后的密码字符串
		//查询时应先进行加密
		adminPassword = MyStringUtils.md5(adminPassword);
		Admin admin = adminDao.login(adminPhone, adminPassword);
		//登陆失败直接返回null
		if (admin == null) {
			return null;
		}
		//登录成功则将对应用户的权限集合写入
		//首先判断用户是否为超级管理员
		String ruleIds = roleDao.getRuleIdsByAdminId(admin.getId());
		if ("".equals(ruleIds) || null == ruleIds) {
			//超管,写入所有权限
			admin.setRuleList(ruleDao.getAllRuleList());
		} else {
			//非超管，写入对应权限
			admin.setRuleList(ruleDao.getRuleListByIds(ruleIds));
		}
		return admin;
	}

	@Override
	public List<Admin> getAdminList() {
		List<Admin> list = adminDao.getAllAdminWithRole();
		return list;
	}

	
}
