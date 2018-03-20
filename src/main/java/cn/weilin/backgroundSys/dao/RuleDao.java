package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.weilin.backgroundSys.entity.Rule;

/**
 * Ȩ��Dao��
 * @author Chen Weilin
 *
 */
public interface RuleDao {

	/**
	 * ����Ȩ�޵�ids��ȡ���õ�Ȩ�޼���
	 * @param ruleIds
	 * @return statusΪ1��Ȩ�޼���
	 */
	public List<Rule> getRuleListByIds(@Param("ruleIds")String ruleIds);
	
	/**
	 * ������п��õ�Ȩ�޼��� �����ڳ���
	 * @param ruleIds
	 * @return ��ó��ܵ�����statusΪ1��Ȩ��
	 */
	public List<Rule> getAllRuleList();
}
