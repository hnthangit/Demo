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

import model.User;
import service.UserService;

@WebServlet("/add")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddController() {
        super();
    }
    
    UserService userService = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			String password = request.getParameter("password");
			String repassword = request.getParameter("repassword");
			String username = request.getParameter("username");
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String description = request.getParameter("description");
			
			Date birthDate = null;
			if (request.getParameter("birthdate").length()!=0)
				birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthdate"));
			
			User user = new User(username, password, firstName, lastName, birthDate, description);
			
			if(password.equals(repassword)) {
				userService.addUser(user);			
				response.sendRedirect("/Demo/");
			}
			else {
				request.setAttribute("user", user);
				RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
				rd.forward(request, response);
			}		
			
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	}

}
