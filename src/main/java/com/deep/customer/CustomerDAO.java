package com.deep.customer;

import java.sql.*;

public class CustomerDAO {
	public Customer checkLogin(String name, String password) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/jt_project";
        String dbUser = "root";
        String dbPassword = "";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM customer WHERE name = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        Customer cust = null;
 
        if (result.next()) {
            cust = new Customer();
            cust.setId(result.getString("id"));
            cust.setName(name);
            cust.setPassword(password);
            cust.setRole(result.getString("role"));
        }
 
        connection.close();
 
        return cust;
	}
}