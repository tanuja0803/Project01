package ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQuery {
	public static void main(String[] args) throws SQLException {
		//Creating database driver & registering the connection
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Establishing connection
		Connection con=DriverManager.getConnection("jdbc:Mysql://106.51.90.215:3333/student", "root@%", "root");
		System.out.println("Conncetion established");
		
		//Creating statement & passing query to read data which returns resultset type value
		Statement stat=con.createStatement();
		ResultSet set=stat.executeQuery("select * from marks;");
		
		//Print table data
		while(set.next()) {
			System.out.println(set.getString("SID")+" "+set.getString("SNAME")+" "+set.getLong("PHNO"));
		}
		
		con.close();
	}
}
