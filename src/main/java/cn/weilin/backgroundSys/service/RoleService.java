package cn.weilin.backgroundSys.service;

import java.util.List;

import cn.weilin.backgroundSys.entity.Role;

/**
 * ��ɫ���� ҵ����
 * @author Chen Weilin
 *
 */
public interface RoleService {

	/**
	 * ������н�ɫ�ļ���
	 * @return
	 */
	public List<Role> getRoleList();
}
