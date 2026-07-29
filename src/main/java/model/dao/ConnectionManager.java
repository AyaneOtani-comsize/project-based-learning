package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * taskdbへ接続
 * @author otani
 */
public class ConnectionManager {

	/**
	 * データベースのURL
	 */
	private final static String URL = "jdbc:mysql://localhost:3306/taskdb";
	
	/**
	 * データベースのユーザ
	 */
	private final static String USER = "root";
	
	/**
	 * データベースのパスワード
	 */
	private final static String PASSWORD = "root";
	
	/**
	 * taskdbへの接続を取得
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
