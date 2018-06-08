package com.fqg.entity;

import java.io.Serializable;
import java.util.List;

public class PageInfo<T> implements Serializable{
	public static final int PAGE_SIZE=5;
	private List<T> data;
	private int pageNo;
	private int pageCount;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public static int getPageSize() {
		return PAGE_SIZE;
	}

	@Override
	public String toString() {
		return "PageInfo{" +
				"data=" + data +
				", pageNo=" + pageNo +
				", pageCount=" + pageCount +
				'}';
	}
}
