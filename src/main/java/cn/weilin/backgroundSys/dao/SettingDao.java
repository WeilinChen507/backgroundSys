package cn.weilin.backgroundSys.dao;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Setting;

/**
 * �������� Dao
 * @author Chen Weilin
 *
 */
public interface SettingDao {

	/**
	 * �����վ����
	 * @return
	 */
	public String getWebTitle();
	
	/**
	 * �����վ��Ȩ
	 * @return
	 */
	public String getCopyright();
	
	
	/**
	 * �����վ���ã�������վ��Ȩ�ͱ���
	 * @return
	 */
	public Setting getWebSetting();
	
	/**
	 * �޸���վ��Ȩ
	 * @param copyright
	 * @return Ӱ������
	 */
	public int updateCopyright(@Param("copyright")String copyright);
	
	/**
	 * �޸���վ����
	 * @param webTitle
	 * @return Ӱ������
	 */
	public int updateWebTitle(@Param("webTitle")String webTitle);
	
	/**
	 * �޸���վ�������� ��������Ͱ�ȥ��
	 * @param webTitle
	 * @param copyright
	 * @return Ӱ������
	 */
	public int updateWebSetting(@Param("webTitle")String webTitle, @Param("copyright")String copyright);
}
