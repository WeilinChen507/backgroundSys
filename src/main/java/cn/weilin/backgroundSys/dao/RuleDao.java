package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Rule;

/**
 * 权限Dao类
 * @author Chen Weilin
 *
 */
public interface RuleDao {

	/**
	 * 根据权限的ids获取可用的权限集合
	 * @param ruleIds
	 * @return status为1的权限集合
	 */
	public List<Rule> getRuleListByIds(@Param("ruleIds")String ruleIds);
	
	/**
	 * 获得所有可用的权限集合 适用于超管
	 * @param ruleIds
	 * @return 获得超管的所有status为1的权限
	 */
	public List<Rule> getAllRuleList();
}
