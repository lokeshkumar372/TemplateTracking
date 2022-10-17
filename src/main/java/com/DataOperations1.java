package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.bean.StatusTable;
import com.bean.Template;
import com.bean.Topic;
import com.bean.Users;

public class DataOperations1 {

	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static Connection con = null;

	DataOperations1() {
		try {
			con = getConnection();
			stmt = getStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static PreparedStatement getpreparedStatement(String s) throws SQLException {
		return con.prepareStatement(s);
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
	
	public Users check(String name, String Password) throws SQLException {
		ResultSet res = stmt.executeQuery("select * from Users where user_email = " + "'" + name + "'"
				+ " and password = " + "'" + Password + "'" + ";");
		Users u=null;
		if(res.next()) {
			u=new Users(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));
		}		
		return u;
	}
	public List<Users> getUsersDetails(String select) throws SQLException {

		String sql = "select * from Users where role = '" + select + "' ;";
		ResultSet res = stmt.executeQuery(sql);
		List<Users> list=new ArrayList();
		Users u=null;
		while(res.next()) {
			list.add(new Users(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)));
		}
		//System.out.println(list);
		
		return list;
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
	public static List<Template> getAllTemplate() throws SQLException {
		String sql = "select * from Template;";
		ResultSet res = stmt.executeQuery(sql);
		List<Template> list=new ArrayList();
		while(res.next()) {
			list.add(new Template(res.getInt(1), res.getString(2)));
		}
		return list;
	}
	public static List<Topic> getTopicByTemplateId(int template_id) throws SQLException {
		String sql = "select * from topic where template_id="+template_id+";";
		ResultSet res = stmt.executeQuery(sql);
		List<Topic> list=new ArrayList();
		while(res.next()) {
			list.add(new Topic(res.getInt(1),res.getInt(2), res.getString(3)));
		}
		return list;
	}
	public static List<Integer> getTopicIdsByTemplate(int template_id) throws SQLException{
		List<Integer> list=new ArrayList();
		String sql="select topic_id from Topic where template_id="+template_id;
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			list.add(rs.getInt(1));
		}
		return list;
	}
	 
	public static Map<Integer,StatusTable> getStatusByTemplateIdAndUserId(int user_id,int template_id) throws SQLException{
		Map<Integer,StatusTable> map=new TreeMap();
		String sql="select * from StatusTable where user_id="+user_id+" and template_id="+template_id+";";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			map.put(rs.getInt(3), new StatusTable(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
		}
		return map;
		
	}
	public static void createStatus(int temp_id, int emp_id, List<Integer> list) throws SQLException {
		pstmt=getpreparedStatement("insert into StatusTable (template_id,user_id,topic_id) values(?,?,?)");
		System.out.println("list="+list);

		for(int i:list) {
			pstmt.setInt(1, temp_id);
			pstmt.setInt(2, emp_id);
			pstmt.setInt(3, i);
			

			System.out.println(pstmt.executeUpdate());
			

		}
		return;

	}
	
	public static List<Template> getAssignedTemplatesByUserId(int id) throws SQLException{
		List<Template> list=new ArrayList();
		String sql="select distinct t.template_id,t.template_name from Template as t, StatusTable as s where s.user_id="+id+" and t.template_id=s.template_id;";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) {
			list.add(new Template(rs.getInt(1),rs.getString(2)));
		}
		return list;
		
	}
	
	public static boolean deleteAssignTemplate(int user_id,int template_id) throws SQLException {
		String sql="delete from StatusTable where user_id="+user_id+" and template_id="+template_id+";";
		int count=stmt.executeUpdate(sql);
		return count!=0;
	}
	
	public static Map<Integer,Set<Template>> EmployeeIdMapTemplates() throws SQLException{
		Map<Integer,Set<Template>> map=new HashMap();
		String sql="select distinct s.user_id,t.template_name,t.template_id from Template as t,StatusTable as s where s.template_id=t.template_id;";
		ResultSet rs=stmt.executeQuery(sql);
		Set<Template> set;
		while(rs.next()) {
			int user_id=rs.getInt(1);
				set=map.getOrDefault(user_id,new TreeSet<Template>());
				set.add(new Template(rs.getInt(3),rs.getString(2)));
				map.put(user_id, set);
		}
		return map;
	}
	public static boolean updateStatusByStatusId(int status_id, String status) throws SQLException {
		String sql="Update StatusTable set status='"+status+"' where status_id="+status_id+";";
		int count=stmt.executeUpdate(sql);
		return count!=0;
	}
	
}


