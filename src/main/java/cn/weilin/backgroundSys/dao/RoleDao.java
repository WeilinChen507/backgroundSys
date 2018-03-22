package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Role;

/**
 * Ȩ�ޱ� Dao��
 * @author Chen Weilin
 *
 */
public interface RoleDao {
	
	/**
	 * ����adminId��ȡ�ù���ԱȨ�޼���
	 * @param adminID
	 * @return Ȩ�޼��� �� 1,34,65,77
	 */
	public String getRuleIdsByAdminId(@Param("adminID")int adminID);
	
	/**
	 * ������н�ɫ����
	 * @return
	 */
	public List<Role> getAllRole();
}
