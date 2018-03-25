package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Rule;

/**
 * 权限Dao
 * @author Chen Weilin
 *
 */
public interface RuleDao {

	/**
	 * 根据权限ID集合获得获得权限集合
	 * @param ruleIds
	 * @return List<Rule>
	 */
	public List<Rule> getRuleListByIds(@Param("ruleIds")String ruleIds);
	
	/**
	 * 获得所有权限集合
	 * 供超级管理员 超级管理员有权限管理
	 * @param ruleIds
	 * @return List<Rule>
	 */
	public List<Rule> getAllRuleList();
}
