package cn.weilin.backgroundSys.dao;

import org.apache.ibatis.annotations.Param;

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
	
	
}
