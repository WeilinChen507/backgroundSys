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
 * 管理员业务逻辑处理 实现类
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
	 * 管理员登录接口
	 */
	public Admin login(String adminPhone, String adminPassword) {
		//将用户所填入的密码进行md5加密
		//用户所填的手机和加密后的密码进行数据库匹配
		adminPassword = MyStringUtils.md5(adminPassword);
		Admin admin = adminDao.login(adminPhone, adminPassword);
		//登陆失败
		if (admin == null) {
			return null;
		}
		//登录成功
		//获取该管理员的权限
		String ruleIds = roleDao.getRuleIdsByAdminId(admin.getId());
		if ("".equals(ruleIds) || null == ruleIds) {
			//权限为空 默认为超管， 写入所有权限
			admin.setRuleList(ruleDao.getAllRuleList());
		} else {
			//将权限写入admin中
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
