package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class Repo {
	
	private Statement stmt = null;
	private Connection con = null;
	Repo() {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.con = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Project;encrypt=true;"
							+ "trustServerCertificate=true;user=NewSA;password=Dbase@1234");
			
			this.stmt = this.con.createStatement();
			
		}catch(Exception e) {
			System.out.println("Driver: "+e.getMessage());
		}
	}
	
	public String check(String name,String Password) throws SQLException {
		
		ResultSet res = stmt.executeQuery("select role from Users where user_email = "+"'"+name+"'"+" and password = "+"'"+Password+"'"+";");
		res.next();
		String k = res.getString(1);
		return k;
	}
	
	
	public ResultSet getEmployeeDetails(String select) throws SQLException {
		String sql = "select user_name,user_email from Users where role = '"+select+"' ;";
		ResultSet res = stmt.executeQuery(sql);
		return res;
		
	}
	
	
}
