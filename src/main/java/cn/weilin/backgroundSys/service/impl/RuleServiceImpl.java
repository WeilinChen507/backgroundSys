package cn.weilin.backgroundSys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.dao.RuleDao;
import cn.weilin.backgroundSys.entity.Rule;
import cn.weilin.backgroundSys.service.RuleService;
/**
 * ruleService 业务操作实现类
 * @author Chen Weilin
 *
 */
@Service
public class RuleServiceImpl implements RuleService {

	@Autowired
	RuleDao ruleDao;
	
	@Override
	public List<Rule> getAllRuleByPage(String page) {
		if (null == page || "".equals(page)) {
			page = "1";
		}
		int sort = Integer.parseInt(page);
		List<Rule> list = ruleDao.getRuleListByParentSort(sort);
		return list;
	}

}
