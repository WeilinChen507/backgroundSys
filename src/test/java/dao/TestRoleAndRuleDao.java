package dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.weilin.backgroundSys.dao.RoleDao;
import cn.weilin.backgroundSys.dao.RuleDao;
import cn.weilin.backgroundSys.entity.Rule;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class TestRoleAndRuleDao {

	@Autowired
	RoleDao roleDao;
	
	@Autowired
	RuleDao ruleDao;
	
	@Test
	public void TestGetRuleIdsByAdminId() {
		String ruleIds = roleDao.getRuleIdsByAdminId(11);
		System.out.println(ruleIds);
	}
	
	@Test
	public void TestGetRuleListByIds() {
		String ruleIds = roleDao.getRuleIdsByAdminId(11);
		List<Rule> ruleList = ruleDao.getRuleListByIds(ruleIds);
		
		for(Rule rule: ruleList) {
			System.out.println(rule.getId() + rule.getRuleName() + rule.getSort());
			System.out.println();
		}
	}
	
	@Test
	public void TestGetAllRuleList() {
		List<Rule> ruleList = ruleDao.getAllRuleList();
		
		for(Rule rule: ruleList) {
			System.out.println(rule.getId() + rule.getRuleName() + rule.getSort());			
		}
	}
	
	@Test
	public void TestGetRuleListByParentSort() {
		int sort = 2;
		List<Rule> ruleList = ruleDao.getRuleListByParentSort(sort);
		
		for(Rule rule: ruleList) {
			System.out.println("id：" + rule.getId() + " 名称："+ rule.getRuleName() + "\n\t"
			+ " 排序："+ rule.getSort() + " 是否禁用：" + rule.getStatus() + " 父id：" + rule.getParentId());			
		}
	}
	
	@Test
	public void TestgetCountOfParentMenu() {
		System.out.println(ruleDao.getCountOfParentMenu());
	}
	
}
