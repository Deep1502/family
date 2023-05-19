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

/**
 * Servlet implementation class AddInsuranceServlet
 */
@WebServlet("/addinsurance")
public class AddInsuranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInsuranceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String company = request.getParameter("company");
		int amount = Integer.parseInt(request.getParameter("amount"));
		String type = request.getParameter("type");
		String destPage="addInsurance.jsp";
		try {
        	String jdbcURL = "jdbc:mysql://localhost:3306/jt_project";
            String dbUser = "root";
            String dbPassword = "";
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    	    String sql = "INSERT INTO insurance VALUES (?, ?, ?, ?)";
    	    PreparedStatement statement = connection.prepareStatement(sql);
    	    statement.setString(1, id);
    	    statement.setString(2, company);
    	    statement.setInt(3, amount);
    	    statement.setString(4, type);
    	    statement.executeUpdate();
    	    
    	    connection.close();
        	HttpSession session=request.getSession(false);
    	    session.setAttribute("message", "Added successfully");
        	RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
        
        } catch (SQLException | ClassNotFoundException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    	}
	}

}
