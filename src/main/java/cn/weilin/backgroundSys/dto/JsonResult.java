package cn.weilin.backgroundSys.dto;

/**
 * 所有ajax返回的json数据都用该类进行一个封装
 * @author Chen Weilin
 *
 */
public class JsonResult<T> {
	
	
	private boolean success;
	
	//访问成功时，data为数据域 否则应为null
	private T data;
	
	//失败时的错误信息描述，否则为null
	private String error;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public JsonResult(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}

	public JsonResult(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}
	
}
