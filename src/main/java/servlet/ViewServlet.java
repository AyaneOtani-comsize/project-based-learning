package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view-servlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログイン画面へ転送
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TaskDAOのインスタンスを生成
		TaskDAO taskDAO = new TaskDAO();
		
		//タスクリスト格納用変数を宣言
		List<TaskBean> taskList = new ArrayList<>();
		
		//DBからタスクリストを取得
		try {
			taskList = taskDAO.selectAll();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		
		//タスクリストをリクエストスコープに格納
		request.setAttribute("taskList", taskList);
		
		//タスク一覧表示画面へ遷移
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

}
