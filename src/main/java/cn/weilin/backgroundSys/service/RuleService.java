package cn.weilin.backgroundSys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.entity.Rule;

/**
 * 超管对权限操作的业务层
 * @author Chen Weilin
 *
 */
public interface RuleService {

	/**
	 * 查询权限
	 * @param page 分页中的页数 默认从1开始
	 * @return 当前页数的rule集合
	 */
	public List<Rule> getAllRuleByPage(String page);
}
