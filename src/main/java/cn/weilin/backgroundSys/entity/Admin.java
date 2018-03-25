package cn.weilin.backgroundSys.entity;

import java.util.Date;
import java.util.List;

/**
 * 管理员类
 * 数据库实体类
 * @author Chen Weilin
 *
 */
public class Admin {

	private int id;
	
	//账号
	private String adminAccount;
	
	private String adminPassword;
	
	private	String adminFullname;
	
	//手机号码 作为登录信息之一
	private String adminPhone;
	
	//状态 1可用2禁用，默认为2
	private short status;
	
	//管理员入场券 抢登用
	private String adminTiket;
	
	private Date lastLoginTime;
	
	private String lastLoginIp;
	
	private Date createTime;
	
	private Date updateTime;
	
	//one-many 管理员权限
	private List<Rule> ruleList;
	
	//one-one 管理员角色
	private Role role;
	
	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Rule> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<Rule> ruleList) {
		this.ruleList = ruleList;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminFullname() {
		return adminFullname;
	}

	public void setAdminFullname(String adminFullname) {
		this.adminFullname = adminFullname;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public short getStatus() {
		return status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getAdminTiket() {
		return adminTiket;
	}

	public void setAdminTiket(String adminTiket) {
		this.adminTiket = adminTiket;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
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


	public Admin(int id, String adminAccount, String adminPassword, String adminFullname, String adminPhone,
			short status, String adminTiket, Date lastLoginTime, String lastLoginIp, Date createTime, Date updateTime,
			List<Rule> ruleList) {
		super();
		this.id = id;
		this.adminAccount = adminAccount;
		this.adminPassword = adminPassword;
		this.adminFullname = adminFullname;
		this.adminPhone = adminPhone;
		this.status = status;
		this.adminTiket = adminTiket;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.ruleList = ruleList;
	}

	public Admin() {
		super();
	}
		
}
