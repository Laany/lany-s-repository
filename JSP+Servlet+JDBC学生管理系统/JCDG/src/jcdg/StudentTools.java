package jcdg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentTools {
			public static List<Student> getStudent(){
					List<Student> ret=null;
					try {
							Class.forName("com.mysql.jdbc.Driver");
							String url="jdbc:mysql://127.0.0.1:3306/students";
							Connection connection=DriverManager.getConnection(url, "root", "zhn19970118");
							Statement statement=connection.createStatement();
							ResultSet set=statement.executeQuery("select * from student;");
							ret=new ArrayList<Student>();
							while(set.next()){
								Student one=new Student(); 
								one.setId(set.getString("student_id"));
								one.setName(set.getString("student_name"));
								one.setSchool(set.getString("school"));
								one.setTel(set.getInt("student_tel"));
								one.setQq(set.getInt("student_qq"));
								one.setAddress(set.getString("address"));
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
