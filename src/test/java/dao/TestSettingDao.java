package dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.weilin.backgroundSys.dao.SettingDao;
import cn.weilin.backgroundSys.entity.Setting;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class TestSettingDao {
	
	@Autowired
	private SettingDao settingDao;
	

	@Test
	public void TestgetWebTitle() {
		System.out.println(settingDao.getWebTitle());
	}
	
	@Test
	public void TestgetCopyright() {
		System.out.println(settingDao.getCopyright());
	}
	
	@Test
	public void TestgetWebSetting() {
		Setting setting = settingDao.getWebSetting();
		System.out.println(setting.getCopyright() + "," + setting.getWebsiteTitle() + ","
				+ setting.getId());
	} 
	

}
