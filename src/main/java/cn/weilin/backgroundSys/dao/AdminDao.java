package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Admin;

/**
 * ����Ա�б�dao
 * @author Chen Weilin
 *
 */
public interface AdminDao {

	/**
	 * �����˺������ж��Ƿ��и�
	 * @param adminPhone
	 * @param adminPassword
	 * @return Adminʵ����
	 */
	Admin login(@Param("adminPhone")String adminPhone, @Param("adminPassword")String adminPassword);
	
	/**
	 * ��ù���Ա��Ϣ �������ɫ���
	 * @return
	 */
	List<Admin> getAllAdminWithRole();
}
