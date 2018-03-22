package cn.weilin.backgroundSys.entity;

import java.util.Date;

/**
 * 角色权限 数据库映射表
 * @author Chen Weilin
 *
 */
public class Role {

	private int id;
	
	//权限名称
	private String roleName;
	
	//权限id所构成的集合
	private String ruleIds;
	
	//角色状态 1正常 2禁用 默认为禁用
	private short status;
	
	//注释
	private	String remark;
	
	private Date createTime;
	
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRuleIds() {
		return ruleIds;
	}

	public void setRuleIds(String ruleIds) {
		this.ruleIds = ruleIds;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Role(int id, String roleName, String ruleIds, short status, String remark, Date createTime,
			Date updateTime) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.ruleIds = ruleIds;
		this.status = status;
		this.remark = remark;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public Role() {
		super();
	}
	
	
	
}
