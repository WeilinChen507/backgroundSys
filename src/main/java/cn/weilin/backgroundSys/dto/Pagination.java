package cn.weilin.backgroundSys.dto;

/**
 * 将分页变量封装
 * 配合layui使用
 * @author Chen Weilin
 *
 */
public class Pagination {

	//总条数
	private int count;
	
	//总页数
	private int sumPage;
	
	//当前页数
	private int currentPage;
	
	//每页条数
	private int countPerPage;

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSumPage() {
		return sumPage;
	}

	public void setSumPage(int sumPage) {
		this.sumPage = sumPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}
}
