package cn.weilin.backgroundSys.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.dto.Pagination;
import cn.weilin.backgroundSys.dto.RuleForm;
import cn.weilin.backgroundSys.entity.Rule;
import cn.weilin.backgroundSys.exception.BaseException;
import cn.weilin.backgroundSys.exception.InputWrongFormatException;

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
	
	/**
	 * 获得rule列表的分页参数
	 * @return
	 */
	public Pagination getPaginationOfRuleList(String page);
	
	/**
	 * 查询全部权限，不分页
	 * @return
	 */
	public List<Rule> getAllRule();
	
	/**
	 * 添加权限规则
	 * @param ruleForm
	 */
	public void addRule (RuleForm ruleForm) throws InputWrongFormatException, BaseException;
	
	/**
	 * 删除
	 * @param ruleId
	 */
	public void deleteRule(int ruleId) throws BaseException;
	
	/**
	 * 根据id查询rule
	 * @param id
	 */
	public Rule getRuleById(int id);

	/**
	 * 更新rule 操作
	 * @param ruleForm
	 * @throws InputWrongFormatException
	 * @throws BaseException
	 */
	public void editRule(RuleForm ruleForm) throws InputWrongFormatException, BaseException;

}
