package com.deep.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deep.customer.Customer;
import com.deep.customer.CustomerDAO;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		String newName = request.getParameter("name");
        String newPassword = request.getParameter("password");
        Customer c = (Customer)session.getAttribute("user");
        String id = c.getId();
        CustomerDAO custDao = new CustomerDAO();
        
         
        try {
            Customer cust = custDao.checkLogin(newName, newPassword);
            String destPage = "editProfile.jsp";
             
            if (cust == null) {
            	String jdbcURL = "jdbc:mysql://localhost:3306/jt_project";
                String dbUser = "root";
                String dbPassword = "";
         
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                String sql = "UPDATE customer SET name = ?, password = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, newName);
                statement.setString(2, newPassword);
                statement.setString(3, id);
         
                statement.executeUpdate();
                cust=new Customer();
                cust.setId(id);
                cust.setName(newName);
                cust.setPassword(newPassword);
                cust.setRole("customer");
                session.setAttribute("user", cust);
                session.setAttribute("message", "Your profile has been changed!!!");
                connection.close();
            	
            } else {
                String message = "Invalid name/password";
                session.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
	}

}
