package jdbc_simple_crud_operation_statement.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class UpdateStudentNameByIdController {

	public static void main(String[] args) {
		
		// 1. Create Connection
		Connection connection;
		Scanner sc = new Scanner(System.in);
		int id = 0;
		String name = null;
		try {
			Driver driver = new Driver();
			
			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "root");
			
			String url = "jdbc:mysql://localhost:3306/jdbc-e4";
			
			connection = driver.connect(url, props);
			System.out.println("Connection Created");
			
			System.out.println("Enter Your Updated Name And Id");
			name = sc.nextLine();
			id = sc.nextInt();
			String sql = "Update student Set name = '"+name+"' where id = "+ id ;
			
			Statement statement = connection.createStatement();
			int r = statement.executeUpdate(sql);
			
			System.out.println("Data Updated :" + r);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
