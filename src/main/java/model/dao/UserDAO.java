package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

/**
 * m_userのDAO
 * @author otani
 */
public class UserDAO {

	/**
	 * ユーザ名の一致するユーザの情報を取得
	 * @param userId 検索条件のユーザ名
	 * @return 条件に合致したユーザ情報
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public UserBean login(String userId) throws ClassNotFoundException, SQLException {
		//取得した利用者情報を保持するためのUserBean
		UserBean user = null;
		
		//SQL文用意
		String sql = "SELECT * FROM m_user WHERE user_id = ?";
		
		//userIdを元に検索
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			//プレースホルダに値を設定
			pstmt.setString(1, userId);
			
			//SQL実行
			ResultSet res = pstmt.executeQuery();
			
			//実行結果をuserに格納
			if(res.next()) {
				user = new UserBean();
				user.setUserId(res.getString("user_id"));
				user.setPassword(res.getString("password"));
				user.setUserName(res.getString("user_name"));
				user.setUpdateDatetime(res.getTimestamp("update_datetime"));
			}
		}
		
		//UserBeanを返す
		return user;
	}
}
