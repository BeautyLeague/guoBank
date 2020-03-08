package com.guobank.liukongfu.util;

import java.util.List;

/**
 * @description 分页工具类
 * @author xutao
 * @date 2017-6-22
 * @version 1.0
 * @since JDK1.7
 */
public class Page<T> {

	protected int pageNo = 1;// 页码（默认第1页）
	protected int pageCount = 10;// 每页记录条数
	protected int totalPage;// 总页数
	protected long totalCount = -1;// 总记录条数
	protected List<T> resultList;// 存放查询结果
	
	private int[] numbers;// 展示页数集合
	private int[] totalNumbers;// 展示总页数集合

	public Page() {

	}

	public Page(int pageNo, int pageCount) {
		if (pageNo <= 0) {
			throw new IllegalArgumentException("页数必须要大于0");
		}
		if (pageCount <= 0) {
			throw new IllegalArgumentException("每页记录数必须要大于0");
		}
		this.pageNo = pageNo;
		this.pageCount = pageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageCount() {
		return pageCount;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		// 如果总数为负数, 表示未设置
		if (totalCount < 0) {
			totalPage = 0;
		}
		else {
			// 计算总页数
			totalPage = (int) ((totalCount / pageCount) + (totalCount
					% pageCount == 0 ? 0 : 1));

			// 获取展示页数集合
			this.setNumbers(totalPage);
		}
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	/**
	 * 设置显示页数集合
	 * @param totalPageCount
	 */
	public void setNumbers(int totalPageCount) {
		if (totalPageCount > 0) {
			// 页面要显示的页数集合
			int[] numbers = new int[totalPageCount > 5 ? 5 : totalPageCount];
			int k = 0;
			for (int i = 0; i < totalPageCount; i++) {
				// 保证当前页为集合的中间
				if ((i >= pageNo - (numbers.length / 2 + 1) || i >= totalPageCount
						- numbers.length)
						&& k < numbers.length) {
					numbers[k] = i + 1;
					k++;
				}
				else if (k >= numbers.length) {
					break;
				}
			}
			this.numbers = numbers;

			// 页面要显示的总页数集合
			this.totalNumbers = new int[totalPageCount];
			for (int j = 0; j < totalPageCount; j++) {
				this.totalNumbers[j] = j + 1;
			}
		}
	}

	public int[] getTotalNumbers() {
		return totalNumbers;
	}

	public void setTotalNumbers(int[] totalNumbers) {
		this.totalNumbers = totalNumbers;
	}

}