package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersModel {
	
	private ArrayList<User> users = new ArrayList<User>();


	public UsersModel() {
	}
	
	public ArrayList<User> get(){

		String query = "select * from users";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", ""); //ip, puerto, bd, user y pass en ese orden

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query); // ResultSet se usa para queries SELECT
			while (rs.next()) {
				Integer empId = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String role = rs.getString(4); 
				String phone = rs.getString(5);
				
				users.add(new User(empId,name,email,role,phone,null,null)); 
			}
			rs.close();
			return users; 

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		return users;
	}
	
	
	
	public boolean add(String name, String email, String role) {
		String query = "INSERT INTO `users` (`id`, `name`, `email`, `role`, `phone`, `create_at`, `update_at`) VALUES (NULL, '"+name+"', '"+email+"', '"+role+"', NULL, NULL, NULL);";
		Connection conn = null;																							//id    name     email role
		Statement stmt = null;	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			 
			if(rs > 0) 
				return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
	}
	
	public boolean update(User user) {

	    String query = "UPDATE users SET name = '"+user.name+"', role = '"+user.role+"', email = '"+user.email+"' WHERE `users`.`id` = "+user.id+";";
		Connection conn = null;																							//id    name     email role
		Statement stmt = null;	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
			stmt = conn.createStatement();
			
			int rs = stmt.executeUpdate(query);
			 
			if(rs > 0) 
				return true; 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		
		return false;
		
	}
}


