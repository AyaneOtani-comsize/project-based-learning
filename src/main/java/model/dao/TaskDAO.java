package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.entity.TaskBean;

/**
 * t_taskのDAO
 */
public class TaskDAO {
	public TaskBean selectAll() {

		//SQL
		String sql = "";
		//userIdを元に検索
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			//プレースホルダに値を設定
			pstmt.setString();

			//SQL実行
			ResultSet res = pstmt.executeQuery();
		}
	}
}
