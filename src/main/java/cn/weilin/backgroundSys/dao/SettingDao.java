package cn.weilin.backgroundSys.dao;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Setting;

/**
 * 公共属性 Dao
 * @author Chen Weilin
 *
 */
public interface SettingDao {

	/**
	 * 获得网站标题
	 * @return
	 */
	public String getWebTitle();
	
	/**
	 * 获得网站版权
	 * @return
	 */
	public String getCopyright();
	
	
	/**
	 * 获得网站设置，包括网站版权和标题
	 * @return
	 */
	public Setting getWebSetting();
	
	/**
	 * 修改网站版权
	 * @param copyright
	 * @return 影响条数
	 */
	public int updateCopyright(@Param("copyright")String copyright);
	
	/**
	 * 修改网站标题
	 * @param webTitle
	 * @return 影响条数
	 */
	public int updateWebTitle(@Param("webTitle")String webTitle);
	
	/**
	 * 修改网站整体设置 包括标题和搬去哪
	 * @param webTitle
	 * @param copyright
	 * @return 影响条数
	 */
	public int updateWebSetting(@Param("webTitle")String webTitle, @Param("copyright")String copyright);
}
