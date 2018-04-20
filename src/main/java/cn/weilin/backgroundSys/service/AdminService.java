package cn.weilin.backgroundSys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.dto.AdminForm;
import cn.weilin.backgroundSys.entity.Admin;
import cn.weilin.backgroundSys.exception.BaseException;
import cn.weilin.backgroundSys.exception.InputWrongFormatException;

/**
 * 管理员业务接口
 * @author Chen Weilin
 */
public interface AdminService {

	/**
	 * 登录 成功则返回admin对象 否则null
	 * @param adminPhone
	 * @param adminPassword
	 * @return 
	 */
	public Admin login(String adminPhone, String adminPassword);
	
	/**
	 * 获得所有管理员 供超管用
	 * @return 所有管理员的集合
	 */
	public List<Admin> getAdminList();
	
	/**
	 * 通过id获取管理员
	 * @param id
	 * @return
	 */
	public Admin GetAdminById(int id);
	
	/**
	 * 添加管理员
	 * @param adminForm
	 * @throws InputWrongFormatException
	 * @throws BaseException
	 */
	public void addAdminByForm(AdminForm adminForm) throws InputWrongFormatException, BaseException;
	
	/**
	 * 删除该id的管理员
	 * @param id
	 */
	public boolean deleteById(int id);
	
	/**
	 * 编辑admin信息
	 * @param adminForm
	 * @throws InputWrongFormatException
	 * @throws BaseException
	 */
	public void editAdminByForm(AdminForm adminForm) throws InputWrongFormatException, BaseException;
	

	
}
