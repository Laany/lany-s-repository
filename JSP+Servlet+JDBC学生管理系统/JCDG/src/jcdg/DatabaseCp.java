package jcdg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;





public class DatabaseCp {
	public static void insertCp(String id, String name, String school, String address, int tel, int qq){
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/students";
			connection = DriverManager.getConnection(url, "root", "zhn19970118");
			//Statement statement = connection.createStatement();
			//statement.executeUpdate(str);
			ps = connection.prepareStatement("insert into student (student_id, student_name, school, student_tel, student_qq, address) values (?, ?, ?, ?, ?, ?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, school);
			ps.setInt(4, tel);
			ps.setInt(5, qq);
			ps.setString(6, address);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void deleteCp(String id){
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/students";
			connection = DriverManager.getConnection(url, "root", "zhn19970118");
			connection.setAutoCommit(false);
			ps = connection.prepareStatement("delete from student where student_id=?");
			ps.setString(1, id);
			ps.executeUpdate();
			ps = connection.prepareStatement("delete from student_grade where student_id=?");
			ps.setString(1, id);
			ps.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	
	//student_grade
	public static void updateCp(String id, String name, String school, String address, int tel, int qq){
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/students";
			connection = DriverManager.getConnection(url, "root", "zhn19970118");
			ps = connection.prepareStatement("update student set student_id=?, student_name=?, school=?, address=?, student_tel=?, student_qq=? where student_id=?");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, school);
			ps.setString(4, address);
			ps.setInt(5, tel);
			ps.setInt(6, qq);
			ps.setString(7, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static Student selectCp(String id){
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		Student student = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/students";
			connection = DriverManager.getConnection(url, "root", "zhn19970118");
			ps = connection.prepareStatement("select * from student where student_id=?");
			ps.setString(1, id);
			set = ps.executeQuery();
			while (set.next())
			{
				student = new Student();
				student.setId(set.getString("student_id"));
				student.setName(set.getString("student_name"));
				student.setSchool(set.getString("school"));
				student.setTel(set.getInt("student_tel"));
				student.setQq(set.getInt("student_qq"));
				student.setAddress(set.getString("address"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}finally {
			try {
				ps.close();
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return student;
	}
	
	public static ResultSet selectALLCp(){
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/students";
			connection = DriverManager.getConnection(url, "root", "zhn19970118");
			statement = connection.createStatement();
			ResultSet set = statement.executeQuery("select * from student;");
			return set;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static List<Administrator> selectAdmCp(String id, String pass){
		Connection connection = null;
		PreparedStatement ps = null;
		List<Administrator> ret=null;
		ResultSet set = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/students";
			connection = DriverManager.getConnection(url, "root", "zhn19970118");
			ps = connection.prepareStatement("select * from user where user_id=? and user_password=?;");
			ps.setString(1, id);
			ps.setString(2, pass);
			set = ps.executeQuery();
			ret=new ArrayList<Administrator>();
			while(set.next()){
				Administrator one=new Administrator(); 
				one.setUser_id(set.getString("user_id"));
				one.setUser_password(set.getString("user_password"));
				ret.add(one);
				}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}finally {
			try {
				set.close();
				ps.close();
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return ret;
	}
}
