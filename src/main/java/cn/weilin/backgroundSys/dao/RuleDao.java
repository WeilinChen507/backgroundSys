package cn.weilin.backgroundSys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameters;

import cn.weilin.backgroundSys.dto.RuleForm;
import cn.weilin.backgroundSys.entity.Rule;

/**
 * 权限Dao
 * @author Chen Weilin
 *
 */
public interface RuleDao {

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Rule getRuleById(@Param("id")int id);
	
	/**
	 * 根据权限ID集合获得获得权限集合
	 * @param ruleIds
	 * @return List<Rule>
	 */
	public List<Rule> getRuleListByIds(@Param("ruleIds")String ruleIds);
	
	/**
	 * 获得所有status为1的我权限集合
	 * 供超级管理员 超级管理员有权限管理
	 * @return List<Rule>
	 */
	public List<Rule> getAllAbleRuleList();
	
	/**
	 * 获得所有权限集合
	 * 供超级管理员 超级管理员有权限管理
	 * @return List<Rule>
	 */
	public List<Rule> getAllRuleList();
	
	/**
	 * 根据最父一级的排序获取其与其子级的权限集合
	 * @param 排序序号
	 * @return
	 */
	public List<Rule> getRuleListByParentSort(@Param("sort")int sort);
	
	/**
	 * 获得父级菜单的个数
	 * 用于分页
	 * @return
	 */
	public int getCountOfParentMenu();
	
	/**
	 * 添加权限
	 * @param rule
	 * @return 影响条数
	 */
	public int addRule(@Param("rule")RuleForm rule, @Param("createTime")int createTime);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public int deleteById(@Param("id")int id);
	
	/**
	 * 根据ruleForm修改
	 * @param ruleForm
	 * @return
	 */
	public int updateByForm(@Param("form")RuleForm ruleForm, @Param("updateTime")int updateTime);
	
}
