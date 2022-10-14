package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bean.Users;

public class DataOperations {

	private static Statement stmt = null;
	private static Connection con = null;

	DataOperations() {
		try {
			con = getConnection();
			stmt = getStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static Statement getStatement() throws SQLException {
		if (stmt == null)
			stmt = con.createStatement();
		return stmt;
	}

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (con == null)
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Project;encrypt=true;"
				+ "trustServerCertificate=true;user=sa;password=Dbase@123");
		return con;
	}

	public String check(String name, String Password) throws SQLException {
		ResultSet res = stmt.executeQuery("select role from Users where user_email = " + "'" + name + "'"
				+ " and password = " + "'" + Password + "'" + ";");
		res.next();
		String k = res.getString(1);
		return k;
	}

	public ResultSet getUsersDetails(String select) throws SQLException {

		String sql = "select * from Users where role = '" + select + "' ;";
		ResultSet res = stmt.executeQuery(sql);
		return res;
	}
	
	
	public boolean createUser(Users u) throws SQLException {
		
		String sql = "insert into Users values ( '"+u.getUser_name()+"' , '"+u.getuser_email()+"' , '"+u.getPassword()+"' , '"+u.getRole()+"' );";
		int k = stmt.executeUpdate(sql);
		return k>0;
		
	}
	
	public boolean deleteEntry(String email) throws SQLException {
		String sql = "Delete from Users where user_email= '"+email+"' ;";
		int k = stmt.executeUpdate(sql);
		
		return k>0;
	}
	public static void delete(String string) throws SQLException {
		String sql = "Delete from Users where user_id= '"+string+"' ;";
		int k = stmt.executeUpdate(sql);
	}

}
