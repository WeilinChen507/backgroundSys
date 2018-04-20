package cn.weilin.backgroundSys.dto;

/**
 * 添加 编辑管理员的表单
 * @author Chen Weilin
 *
 */
public class AdminForm {
	
	private Integer id;
	
	private String adminAccount;
	
	private String adminPassword;
	
	private String repeatedPassword;
	
	private String adminFullname;
	
	private String adminPhone;
	
	private Integer status;	//1可用 2禁用
	
	private Integer roleId;

	
	
	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "account" + this.adminAccount + ", " + 
				"phone" + this.adminPhone + ", " + 
				"password" + this.adminPassword + ", " + 
				"password2" + this.repeatedPassword + ", " + 
				"name" + this.adminFullname + ", " + 
				"status" + this.status + ", " + 
				"roleId" + this.roleId ;
	}

	public AdminForm(Integer id, String adminAccount, String adminFullname, String adminPhone, Integer status,
			Integer roleId) {
		super();
		this.id = id;
		this.adminAccount = adminAccount;
		this.adminFullname = adminFullname;
		this.adminPhone = adminPhone;
		this.status = status;
		this.roleId = roleId;
	}

	public AdminForm() {
		super();
	}
	
	
	
	
}
