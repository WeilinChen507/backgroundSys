package cn.weilin.backgroundSys.dto;

import cn.weilin.backgroundSys.entity.Role;

public class RoleForm {

	private Integer id;
	
	private String roleName;
	
	private String[] ruleIds;
	
	private Integer status;
	
	private String remark;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String[] getRuleIds() {
		return ruleIds;
	}

	public void setRuleIds(String[] ruleIds) {
		this.ruleIds = ruleIds;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	
	
	public RoleForm(Role role) {
		this.id = role.getId();
		this.roleName = role.getRoleName();
		this.status = (int) role.getStatus();
		this.remark = role.getRemark();
		this.ruleIds = role.getRuleIds().split(",");
	}

	public RoleForm() {
		super();
	}

	public RoleForm(Integer id, String roleName, String[] ruleIds, Integer status, String remark) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.ruleIds = ruleIds;
		this.status = status;
		this.remark = remark;
	}

	@Override
	public String toString() {
		String ids = "";
		if (this.ruleIds != null) {
			for(String id : this.ruleIds) {
				ids += (id.toString() + ",");
			}
		}
		return "roleName:" + this.roleName + ", " +
				"remark:" + this.remark + ", " +
				"status:" + this.status + ", " +
				"ruleIds:" + "[" +ids + "]";

	}
	
}
