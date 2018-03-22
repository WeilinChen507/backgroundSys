package dao;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import cn.weilin.backgroundSys.dao.AdminDao;
import cn.weilin.backgroundSys.entity.Admin;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class TestAdminDao {

	@Autowired
	private AdminDao adminDao;
	
	@Test
	public void testLogin() {
		String password = "156262";
		String phone = "15626269165";
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		Admin admin = adminDao.login(phone, password);
		if (admin == null) {
			System.out.println("null");
		} else {
			System.out.println(admin.getId() + "  "
					+ admin.getAdminPhone() + "  "
					+ admin.getAdminPassword());
			System.out.println("创建时间为" + admin.getCreateTime());
		}
	}
	
	@Test
	public void testgetAllAdminWithRole(){
		List<Admin> list = adminDao.getAllAdminWithRole();
		for(Admin admin: list) {
			System.out.println(admin.getAdminAccount());
			System.out.println(admin.getAdminFullname());
			if (admin.getRole() != null) {
				System.out.println(admin.getRole().getRoleName());
			}
			System.out.println("=============");
		}
	}
	
}
