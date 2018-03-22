package cn.weilin.backgroundSys.entity;

import java.util.Date;

/**
 * 权限类  数据库实体类
 * @author Chen Weilin
 *
 */
public class Rule {

	private int id;
	
	private String ruleName;
	
	//权限规则
	private String rule;
	
	//是否为菜单 1是2否 默认2
	private short isMenu;
	
	//父级ID 0为1级  非0为子级
	private int parentId;
	
	//图标
	private String icon;
	
	//排序
	private int sort;
	
	//状态 1可用 2禁用 默认为2
	private short status;
	
	private Date createTime;
	
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public short getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(short isMenu) {
		this.isMenu = isMenu;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Rule(int id, String ruleName, String rule, short isMenu, int parentId, String icon, int sort, short status,
			Date createTime, Date updateTime) {
		super();
		this.id = id;
		this.ruleName = ruleName;
		this.rule = rule;
		this.isMenu = isMenu;
		this.parentId = parentId;
		this.icon = icon;
		this.sort = sort;
		this.status = status;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Rule() {
		super();
	}
	
	
	
}
