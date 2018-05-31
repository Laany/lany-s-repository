package jcdg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GradeCp {
	public static void insertCp(String id, String name, String grade){
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/students";
			connection = DriverManager.getConnection(url, "root", "zhn19970118");
			//Statement statement = connection.createStatement();
			//statement.executeUpdate(str);
			ps = connection.prepareStatement("insert into student_grade (student_id, student_name, grade) values (?, ?, ?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, grade);
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
	
	public static void deleteCp(String id){
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/students";
			connection = DriverManager.getConnection(url, "root", "zhn19970118");
			ps = connection.prepareStatement("delete from student_grade where student_id=?");
			ps.setString(1, id);
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
	
	public static void updateCp(String id, String grade){
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/students";
			connection = DriverManager.getConnection(url, "root", "zhn19970118");
			ps = connection.prepareStatement("update student_grade set grade=? where student_id=?");
			ps.setString(1, grade);
			ps.setString(2, id);
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
	
	public static List<Grade> selectALLCp(){
		List<Grade> ret=null;
		try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/students";
				Connection connection=DriverManager.getConnection(url, "root", "zhn19970118");
				Statement statement=connection.createStatement();
				ResultSet set=statement.executeQuery("select * from student_grade;");
				ret=new ArrayList<Grade>();
				while(set.next()){
					Grade one = new Grade();
					one.setStudent_id(set.getString("student_id"));
					one.setStudent_name(set.getString("student_name"));
					one.setGrade(set.getString("grade"));
					ret.add(one);
				}
				set.close();
				statement.close();
				connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			ret=null;
		}
		return ret;
	}


	public static Grade selectCp(String id){
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet set = null;
		Grade grade = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/students";
			connection = DriverManager.getConnection(url, "root", "zhn19970118");
			ps = connection.prepareStatement("select * from student_grade where student_id=?");
			ps.setString(1, id);
			set = ps.executeQuery();
			while (set.next())
			{
				grade = new Grade();
				grade.setStudent_id(set.getString("student_id"));
				grade.setStudent_name(set.getString("student_name"));
				grade.setGrade(set.getString("grade"));
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
		return grade;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
