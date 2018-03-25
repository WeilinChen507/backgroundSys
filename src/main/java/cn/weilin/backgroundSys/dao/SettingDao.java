package cn.weilin.backgroundSys.dao;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Setting;

/**
 * Setting 网站设置Dao
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
	 * 获得网站
	 * @return
	 */
	public String getCopyright();
	
	
	/**
	 * 获得网站设置
	 * @return Setting
	 */
	public Setting getWebSetting();
	
	/**
	 * 更新版权设置
	 * @param copyright
	 * @return 更新条数 失败为0
	 */
	public int updateCopyright(@Param("copyright")String copyright);
	
	/**
	 * 更新网站标题
	 * @param webTitle
	 * @return 更新条数1， 失败为0
	 */
	public int updateWebTitle(@Param("webTitle")String webTitle);
	
	/**
	 * 更新网站设置
	 * @param webTitle
	 * @param copyright
	 * @return 更新条数 失败为0
	 */
	public int updateWebSetting(@Param("webTitle")String webTitle, @Param("copyright")String copyright);
}
