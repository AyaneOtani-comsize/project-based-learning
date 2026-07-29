package model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * m_userの情報を保持する
 * @author otani
 */
public class UserBean implements Serializable {

	/**
	 * ユーザID
	 */
	private String userId;
	
	/**
	 * パスワード
	 */
	private String password;
	
	/**
	 * ユーザ名
	 */
	private String userName;
	
	/**
	 * 更新日時
	 */
	private Timestamp updateDatetime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Timestamp getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Timestamp updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}
