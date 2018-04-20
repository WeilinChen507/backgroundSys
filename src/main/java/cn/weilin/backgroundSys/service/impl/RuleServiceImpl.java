package cn.weilin.backgroundSys.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.weilin.backgroundSys.dao.RuleDao;
import cn.weilin.backgroundSys.dto.Pagination;
import cn.weilin.backgroundSys.dto.RuleForm;
import cn.weilin.backgroundSys.entity.Rule;
import cn.weilin.backgroundSys.exception.BaseException;
import cn.weilin.backgroundSys.exception.InputWrongFormatException;
import cn.weilin.backgroundSys.service.RuleService;
/**
 * ruleService 业务操作实现类
 * @author Chen Weilin
 *
 */
@Service
public class RuleServiceImpl implements RuleService {

	@Autowired
	private RuleDao ruleDao;
	
	@Override
	public List<Rule> getAllRuleByPage(String page) {
		if (null == page || "".equals(page)) {
			page = "1";
		}
		int sort = Integer.parseInt(page);
		List<Rule> list = ruleDao.getRuleListByParentSort(sort);
		return list;
	}

	@Override
	public Pagination getPaginationOfRuleList(String page) {
		Pagination pagination = new  Pagination();
		if (null == page || "".equals(page)) {
			page = "1";
		}
		pagination.setCurrentPage(Integer.parseInt(page));
		pagination.setSumPage(ruleDao.getCountOfParentMenu());
		return pagination;
	}

	@Override
	public List<Rule> getAllRule() {
		return ruleDao.getAllRuleList();
	}

	@Override
	public void addRule(RuleForm ruleForm) 
			throws InputWrongFormatException, BaseException{
		//检查表单
		try {
			checkRuleForm(ruleForm);
		} catch (InputWrongFormatException e) {
			throw e;
		} catch (BaseException e) {
			throw e;
		}
		//数据库添加操作
		try {
			ruleDao.addRule(ruleForm, (int)(new Date().getTime()/1000));
		} catch (Exception e) {	//内部错误
			throw new BaseException("系统繁忙，请稍后再试");
		}
	}

	/**
	 * 检查权限表单
	 */
	private void checkRuleForm(RuleForm ruleForm) 
			throws InputWrongFormatException, BaseException{
		//非空检查
		if (ruleForm.getIsMenu() == null || ruleForm.getParentId() == null || ruleForm.getRule() == null
				|| ruleForm.getRuleName() == null || ruleForm.getSort() == null || ruleForm.getStatus() == null) {
			throw new InputWrongFormatException("必填字段不能为空");
		}
	}

	@Override
	public void deleteRule(int ruleId) throws BaseException{
		try {
			ruleDao.deleteById(ruleId);
		} catch (Exception e) {
			throw new BaseException("系统异常，请稍候再试");
		}
	}

	@Override
	public Rule getRuleById(int id) {
		Rule rule = ruleDao.getRuleById(id);
		return rule;
	}

	@Override
	public void editRule(RuleForm ruleForm) throws InputWrongFormatException, BaseException {
		if (ruleForm.getId() == null) {
			throw new InputWrongFormatException("必填字段不能为空");
		}
		try {
			checkRuleForm(ruleForm);
		} catch (InputWrongFormatException e) {
			throw e;
		} catch (BaseException e) {
			throw e;
		}
		try {
			ruleDao.updateByForm(ruleForm, (int)(new Date().getTime()/1000));
		} catch (Exception e) {
			//内部异常
			throw new BaseException("系统繁忙，请稍候再试");
		}
		
	}
		
}
