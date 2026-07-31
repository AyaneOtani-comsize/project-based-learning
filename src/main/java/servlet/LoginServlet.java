package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		//リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメータを取得
		String userId = request.getParameter("userId"); //ユーザ名
		String password = request.getParameter("password"); //パスワード
		
		//セッションオブジェクトを取得
		HttpSession session = request.getSession();
		
		//ログインエラーが起きたという情報をセッションスコープに格納
		session.setAttribute("loginErr", true);
		
		//転送先パスを宣言し、初期値をログイン画面にする
		String url = "login.jsp";

		//入力内容が不正であった場合、即座に転送を行い、これより後ろの行は実行しない
		/* 
		 * ユーザ名：未入力、文字数が24より多い
		 * パスワード：未入力、文字数が32より多い
		 */
		if (userId == null || userId.length() < 1 || userId.length() > 24 
				|| password == null || password.length() < 1 || password.length() > 32) {
			//転送
			request.getRequestDispatcher(url).forward(request, response);
			return; //後ろの行は実行しない
		}
		
		//UserDAOのインスタンスを生成
		UserDAO userDAO = new UserDAO();
		
		/*ログイン認証を行う*/
		
		//ログインするユーザの情報を格納する変数を宣言
		UserBean user = null;
		
		//ユーザ名を元にUserBeanを取得
		try {
			user = userDAO.login(userId);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		
		//もしユーザ情報が取得されており、パスワードが一致したのならログイン成功
		if (user != null && password.equals(user.getPassword())) {
			//ログイン成功した場合
			//セッションスコープ内のログインエラーが起きたという情報を消去
			session.removeAttribute("loginErr");
			
			//ユーザ情報をセッションスコープに格納
			session.setAttribute("user", user);
			
			//転送先をメニュー画面にする
			url = "menu.jsp";
		}
		
		//転送
		request.getRequestDispatcher(url).forward(request, response);
	}

}
