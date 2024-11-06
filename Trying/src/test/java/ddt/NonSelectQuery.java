package ddt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {
	public static void main(String[] args) throws SQLException {
		//Creating database driver & registering the connection
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Establishing connection
		Connection con=DriverManager.getConnection("jdbc:Mysql://106.51.90.215:3333/student", "root@%", "root");
		System.out.println("Conncetion established");
		
		
		//Inserting record into table by creating a statement and passing the query which returns int type value
		Statement stat1=con.createStatement();
		int val=stat1.executeUpdate("insert into marks values('S005','Arpita',8893340981);");
		System.out.println("Information of a student inserted");
		
		//Printing table data after inserting
		Statement stat=con.createStatement();
		ResultSet set=stat.executeQuery("select * from marks;");
		
		while(set.next()) {
			System.out.println(set.getString("SID")+" "+set.getString("SNAME")+" "+set.getLong("PHNO"));
		}
		con.close();
	}

}
