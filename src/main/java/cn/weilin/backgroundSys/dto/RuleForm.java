package cn.weilin.backgroundSys.dto;

import java.sql.Date;

import cn.weilin.backgroundSys.entity.Rule;

/**
 * 添加或者编辑权限rule的表单obj
 * @author Chen Weilin
 *
 */
public class RuleForm {

	private Integer id;	//权限id
	
	private String ruleName;	//权限名称
	
	private String rule;		//权限规则uri
	
	private Integer isMenu;			//1是2不是
	
	private Integer parentId;		//父级id
	
	private Integer sort;			//排序
	
	private Integer status;			//1可用2禁用
	
	private String icon;		//权限图标，暂未开发，留作备用

	
	public RuleForm() {
		super();
	}

	public RuleForm(Rule rule) {
		this.id = rule.getId();
		this.ruleName = rule.getRuleName();
		this.rule = rule.getRule();
		this.isMenu = (int) rule.getIsMenu();
		this.parentId = rule.getParentId();
		this.sort = rule.getSort();
		this.status = rule.getSort();
		this.icon = rule.getIcon();
	}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public String getRuleName() {
		return ruleName;
	}



	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}



	public String getRule() {
		return rule;
	}



	public void setRule(String rule) {
		this.rule = rule;
	}



	public Integer getIsMenu() {
		return isMenu;
	}



	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}



	public Integer getParentId() {
		return parentId;
	}



	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}



	public Integer getSort() {
		return sort;
	}



	public void setSort(Integer sort) {
		this.sort = sort;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public String getIcon() {
		return icon;
	}



	public void setIcon(String icon) {
		this.icon = icon;
	}



	@Override
	public String toString() {
		return  "id" + this.id + ", " + 
				"ruleName" +this.ruleName + ", " +
				"rule" + this.rule + ", " +
				"isMenu" + this.isMenu + ", " +
				"parentId" + this.parentId + ", " +
				"sort" + this.sort +  ", " +
				"status" + this.status;
	}
	
	
}
