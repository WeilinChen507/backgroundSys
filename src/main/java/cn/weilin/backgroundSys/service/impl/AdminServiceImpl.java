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
	 * ��¼�ӿڵ�ʵ�ֲ���
	 */
	public Admin login(String adminPhone, String adminPassword) {
		//���ݿ��д�����Ǽ��ܺ�������ַ���
		//��ѯʱӦ�Ƚ��м���
		adminPassword = MyStringUtils.md5(adminPassword);
		Admin admin = adminDao.login(adminPhone, adminPassword);
		//��½ʧ��ֱ�ӷ���null
		if (admin == null) {
			return null;
		}
		//��¼�ɹ��򽫶�Ӧ�û���Ȩ�޼���д��
		//�����ж��û��Ƿ�Ϊ��������Ա
		String ruleIds = roleDao.getRuleIdsByAdminId(admin.getId());
		if ("".equals(ruleIds) || null == ruleIds) {
			//����,д������Ȩ��
			admin.setRuleList(ruleDao.getAllRuleList());
		} else {
			//�ǳ��ܣ�д���ӦȨ��
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
