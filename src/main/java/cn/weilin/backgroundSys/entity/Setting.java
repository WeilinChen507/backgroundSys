package cn.weilin.backgroundSys.entity;

/**
 * ��վ������
 * @author Chen Weilin
 *
 */
public class Setting {
	
	int id;
	
	//��վ����
	String websiteTitle;
	
	//��վ��Ȩ
	String copyright;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWebsiteTitle() {
		return websiteTitle;
	}

	public void setWebsiteTitle(String websiteTitle) {
		this.websiteTitle = websiteTitle;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public Setting(int id, String websiteTitle, String copyright) {
		super();
		this.id = id;
		this.websiteTitle = websiteTitle;
		this.copyright = copyright;
	}

	public Setting() {
		super();
	}
	
	
}
