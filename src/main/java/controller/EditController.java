package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

@WebServlet("/edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditController() {
		super();
	}

	UserService userSerivce = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("username")==null)
			response.sendRedirect("/Demo/");
		else {
			String username = request.getParameter("username");
			request.setAttribute("user", userSerivce.getOneUser(username));

			RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");

			String username = request.getParameter("username");
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String description = request.getParameter("description");

			Date birthDate = null;
			if (request.getParameter("birthdate").length() != 0)
				birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthdate"));

			userSerivce.updateUser(username, firstName, lastName, birthDate, description);

			response.sendRedirect("/Demo/");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
