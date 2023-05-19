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

import com.deep.customer.Customer;
import com.deep.customer.CustomerDAO;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		CustomerDAO custDao = new CustomerDAO();
 
        try {
        	Customer cust = custDao.checkLogin(name, password);
        	String destPage="register.jsp";
        	
        	if(cust==null) {
        		String jdbcURL = "jdbc:mysql://localhost:3306/jt_project";
                String dbUser = "root";
                String dbPassword = "";
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    	        String sql = "INSERT INTO customer VALUES (?, ?, ?, 'customer')";
    	        PreparedStatement statement = connection.prepareStatement(sql);
    	        statement.setString(1, id);
    	        statement.setString(2, name);
    	        statement.setString(3, password);
    	 
    	        statement.executeUpdate();
    	        destPage="login.jsp";
    	        connection.close();
        	}
        	
        	RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        
        } catch (SQLException | ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    	}
        	
 
	}

}
