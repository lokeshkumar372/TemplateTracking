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
				+ "trustServerCertificate=true;user=Newsa;password=Dbase@1234");
		return con;
	}

	public Users check(String name, String Password) throws SQLException {
		ResultSet res = stmt.executeQuery("select * from Users where user_email = " + "'" + name + "'"
				+ " and password = " + "'" + Password + "'" + ";");
		Users u=null;
		if(res.next()) {
			 u=new Users();
			u.setUser_id(res.getInt(1));
			u.setUser_name(res.getString(2));
			u.setuser_email(res.getString(3));
			u.setPassword(res.getString(4));
			u.setRole(res.getString(5));
		}
		
		
		return u;
	}

	public ResultSet getUsersDetails(String select) throws SQLException {

		String sql = "select * from Users where role = '" + select + "' ;";
		ResultSet res = stmt.executeQuery(sql);
		return res;
	}

	public boolean createUser(Users u) throws SQLException {

		String sql = "insert into Users values ( '" + u.getUser_name() + "' , '" + u.getuser_email() + "' , '"
				+ u.getPassword() + "' , '" + u.getRole() + "' );";
		int k = stmt.executeUpdate(sql);
		return k > 0;

	}

	public boolean deleteEntry(String email) throws SQLException {
		String sql = "Delete from Users where user_email= '" + email + "' ;";
		int k = stmt.executeUpdate(sql);

		return k > 0;
	}

	public static void delete(String string) throws SQLException {
		String sql = "Delete from Users where user_id= '" + string + "' ;";
		int k = stmt.executeUpdate(sql);
	}

	public static void createTemplate(String template_name) throws SQLException {

		String sql = "insert into Template values ( '" + template_name + "');";
		stmt.executeUpdate(sql);
		
	}

	public static void createTopics(String[] topics, int template_id) throws SQLException {
		for (String topic : topics) {
			String sql = "insert into Topic values ( '" + template_id + "' , '" + topic + "' );";
			stmt.executeUpdate(sql);
		}

	}
	
	public static int getTemplateId(String template_name) throws SQLException{
		String sql = "select template_id from Template where template_name = '"+template_name+"' ;";
		ResultSet res = stmt.executeQuery(sql);
		res.next();
		int k = res.getInt(1);
		
		return k;
	}
	
}

