package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class ConnectionManagerTest {

	@Test
	void getConnectionTest_取得成功() {
		//Arrange
		//戻り値を格納する変数
		Connection con = null;
		
		//Act
		try {
			con = ConnectionManager.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//Assert
		assertNotNull(con, "戻り値が返ってくるはず");
	}

}
