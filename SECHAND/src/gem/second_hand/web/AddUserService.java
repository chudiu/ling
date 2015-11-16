package gem.second_hand.web;



import gem.second_hand.entity.User;
import gem.second_hand.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddUserService
 */
public class AddUserService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("UserName");
		String password = request.getParameter("UserPassword");
		String nickname = request.getParameter("UserNickname");
		String school_id = request.getParameter("UserSchool_id");
		String sex = request.getParameter("UserSex");
		String phone = request.getParameter("UserPhone");
		String email = request.getParameter("UserEmail");
		PrintWriter out = response.getWriter();
		out.println("woyaoqifei");
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		user.setNickname(nickname);
		if(school_id!=null){
		user.setSchool_id(Integer.parseInt(school_id));
		}
		if (sex!=null) {
			user.setSex(Integer.parseInt(sex));
		}
		if (phone!=null) {
			user.setPhone(phone);
		}
		if (email!=null) {
			user.setEmail(email);
		}
		new UserService().save(user);
		out.close();
	}
}
