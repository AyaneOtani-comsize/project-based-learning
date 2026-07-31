package model.entity;

import java.util.Date;

public class TaskBean {
	/**
	 * タスクID
	 */
	private int taskId;
	/**
	 * タスク名
	 */
	private String taskName;
	/**
	 * カテゴリ
	 */
	private String categoryName;
	/**
	 * 期限
	 */
	private Date limitDate;
	/**
	 * 担当者
	 */
	private String userName;
	/**
	 * ステータス
	 */
	private String statusName;
	/**
	 * メモ
	 */
	private String memo;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public String getUserName() {
		return userName;
	}

	public String getStatusName() {
		return statusName;
	}

	public String getMemo() {
		return memo;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
