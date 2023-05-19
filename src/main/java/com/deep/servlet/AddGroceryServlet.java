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
 * Servlet implementation class AddGroceryServlet
 */
@WebServlet("/addgrocery")
public class AddGroceryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGroceryServlet() {
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
		int price = Integer.parseInt(request.getParameter("price"));
		String destPage="addGrocery.jsp";
		try {
        	String jdbcURL = "jdbc:mysql://localhost:3306/jt_project";
            String dbUser = "root";
            String dbPassword = "";
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    	    String sql = "INSERT INTO grocery VALUES (?, ?, ?)";
    	    PreparedStatement statement = connection.prepareStatement(sql);
    	    statement.setString(1, id);
    	    statement.setString(2, name);
    	    statement.setInt(3, price);
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
