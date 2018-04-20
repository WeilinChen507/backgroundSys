package cn.weilin.backgroundSys.service.impl;

import java.util.Date;
import java.util.List;

import org.omg.CORBA.INITIALIZE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.weilin.backgroundSys.Util.MyStringUtils;
import cn.weilin.backgroundSys.Util.ValidatorUtil;
import cn.weilin.backgroundSys.dao.AdminDao;
import cn.weilin.backgroundSys.dao.AdminRoleDao;
import cn.weilin.backgroundSys.dao.RoleDao;
import cn.weilin.backgroundSys.dao.RuleDao;
import cn.weilin.backgroundSys.dto.AdminForm;
import cn.weilin.backgroundSys.entity.Admin;
import cn.weilin.backgroundSys.exception.BaseException;
import cn.weilin.backgroundSys.exception.InputWrongFormatException;
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
	
	@Autowired
	private AdminRoleDao adminRoleDao;
	
	/**
	 * 管理员登录接口
	 */
	@Transactional
	@Override
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
			//权限为空 默认为超管， 写入所有可用的权限
			admin.setRuleList(ruleDao.getAllAbleRuleList());
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

	@Transactional
	@Override
	public Admin GetAdminById(int id) {
		Admin admin = adminDao.getAdminWithRoleById(id);
		//获取该管理员的权限
		String ruleIds = roleDao.getRuleIdsByAdminId(admin.getId());
		if ("".equals(ruleIds) || null == ruleIds) {
			//权限为空 默认为超管， 写入所有权限
			admin.setRuleList(ruleDao.getAllAbleRuleList());
		} else {
			//将权限写入admin中
			admin.setRuleList(ruleDao.getRuleListByIds(ruleIds));
		}
		return admin;
	}

	@Transactional
	@Override
	public void addAdminByForm(AdminForm adminForm) throws InputWrongFormatException, BaseException {
		try {
			checkAdminForm(adminForm);
		} catch (InputWrongFormatException e) {
			throw e;
		}
		//写入admin表和一对一映射表
		try {
			adminDao.addAdminByAdminForm(adminForm);
			adminRoleDao.addMapping(adminForm.getId(), adminForm.getRoleId());
		} catch (Exception e) {
			throw new BaseException("系统繁忙，请稍后再试");
		}
		
	}

	/**
	 * 表单检查
	 * id不检查是否为空
	 * 非空检查、字段规范检查、二次密码检查
	 * @param adminForm
	 * @throws InputWrongFormatException
	 * @throws BaseException
	 */
	private void checkAdminForm(AdminForm adminForm) throws InputWrongFormatException, BaseException {
		if (adminForm == null || adminForm.getAdminAccount() == null ||adminForm.getAdminFullname() == null
				|| adminForm.getAdminPassword() == null || adminForm.getRepeatedPassword() == null
				|| adminForm.getAdminPhone() == null || adminForm.getRoleId() ==null || adminForm.getStatus() == null) {
			throw new InputWrongFormatException("必填字段不能为空");
		}

		if (!ValidatorUtil.isUsername(adminForm.getAdminAccount())) {
			throw new InputWrongFormatException("账号不能有特殊字符");
		}
		if (!ValidatorUtil.isMobile(adminForm.getAdminPhone())) {
			throw new InputWrongFormatException("手机号码格式错误");
		}
		if (!ValidatorUtil.isPassword(adminForm.getAdminPassword())) {
			throw new InputWrongFormatException("密码必须6到12位，且不能出现空格");
		}
		if (!adminForm.getAdminPassword().equals(adminForm.getRepeatedPassword())) {
			throw new InputWrongFormatException("两次密码不一致");
		}
	}

	@Override
	public boolean deleteById(int id) {
		try {
			int num = adminDao.deleteAdminById(id);
			if (num == 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void editAdminByForm(AdminForm adminForm) throws InputWrongFormatException, BaseException {
		//检查数据
		if (adminForm.getId() == null) {
			throw new InputWrongFormatException("必填字段不能为空");
		}
		try {
			checkAdminForm(adminForm);
		} catch (InputWrongFormatException e) {
			throw e;
		}
		//数据库操作
		try {
			//更新admin表和映射表
			adminDao.updateByAdminForm(adminForm);
			adminRoleDao.updateMapping(adminForm.getId(), adminForm.getRoleId());
		} catch (Exception e) {
			throw new BaseException("系统繁忙，请稍候再试");
		}
	}


	
}
