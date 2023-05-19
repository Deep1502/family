package com.deep.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadInventoryServlet
 */
@WebServlet("/downloadinventory")
public class DownloadInventoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadInventoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String jdbcURL = "jdbc:mysql://localhost:3306/jt_project";
	        String dbUser = "root";
	        String dbPassword = "";
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	        String sql = "SELECT * FROM grocery";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        ResultSet result = statement.executeQuery();

	        FileWriter fout=new FileWriter("inventory.txt", true);
	        fout.write("--Grocery--");
	        fout.write("\r\n");
	        while(result.next()) {
	        	String row = result.getString("id")+", "+result.getString("name")+", "+result.getInt("price");
	        	fout.write(row);
	        	fout.write("\r\n");
	        }
	        sql = "SELECT * FROM bill";
	        statement = connection.prepareStatement(sql);
	        result = statement.executeQuery();
	        fout.write("\r\n");
	        fout.write("--Bill--");
	        fout.write("\r\n");
	        while(result.next()) {
	        	String row = result.getString("id")+", "+result.getString("type")+", "+result.getInt("amount");
	        	fout.write(row);
	        	fout.write("\r\n");
	        }
	        sql = "SELECT * FROM insurance";
	        statement = connection.prepareStatement(sql);
	        result = statement.executeQuery();
	        fout.write("\r\n");
	        fout.write("--Insurance--");
	        fout.write("\r\n");
	        while(result.next()) {
	        	String row = result.getString("id")+", "+result.getString("company")+", "+result.getInt("amount")+", "+result.getString("type");
	        	fout.write(row);
	        	fout.write("\r\n");
	        }
	        fout.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminhome.jsp");
        dispatcher.forward(request, response);
	}

}
