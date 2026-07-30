package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;

/**
 * t_taskのDAO
 */
public class TaskDAO {
	public List<TaskBean> selectAll() throws SQLException, ClassNotFoundException {
		//取得したタスク情報を保持するためのUserBean
		TaskBean task = null;
		
		//取得したをタスク情報を詰めるためのリスト
		List<TaskBean> list = new ArrayList<TaskBean>();
		//SQL
		String sql = "SELECT t1.task_id, t1.task_name, c2.category_name, t1.limit_date, u3.user_name, s4.status_name, t1.memo\r\n"
				+ "    FROM t_task t1 INNER JOIN m_category c2 ON t1.category_id = c2.category_id\r\n"
				+ "    INNER JOIN m_user u3 ON t1.user_id = u3.user_id\r\n"
				+ "    INNER JOIN m_status s4 ON t1.status_code = s4.status_code;";
		//userIdを元に検索
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			//SQL実行
			ResultSet res = pstmt.executeQuery(sql);
			while (res.next()) {
				task = new TaskBean();
				task.setTaskId(res.getInt("task_id"));
				task.setTaskName(res.getString("task_name"));
				task.setCategoryName(res.getString("categoryName"));
				task.setLimitDate(res.getDate("limitDate"));
				task.setStatusName(res.getString("statusName"));
				task.setMemo(res.getString("memo"));
				
				list.add(task);
			}

		}
		return list;
	}
}
