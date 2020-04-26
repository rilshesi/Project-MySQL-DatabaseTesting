package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.remote.DesiredCapabilities;


public class JdbcConnection {
	
	
	public static void main(String args[]) throws SQLException{
		
		String host="localhost";
		String port= "3306";
		String url = "jdbc:mysql://"+host+":"+port+"/employeeportal?" + "autoReconnect=true&useSSL=false";
		String user =  "root";
		String password = "Rodmanraylex1";
	// Connection to database
	// the code below only works for MySQL database. We need to use another code for other Database connection
	// url = "jdbc:mysql://"+host+":"+port+"/databaseName"
	//provide the port no where sql is kistening and the local host where its downloaded + database name
	//by default port number is 3306
		
	Connection con = DriverManager.getConnection(url,user, password);
	
	
	// now we need to create a statement just like a path from our java script to send the queries
	// create the statement and throw it in an object
	
	Statement s = con.createStatement();
	
	// Now execute query on that statement and throw it in ReseltSet
	//    s.executeQuery(sql);  where sql is your query from MySQL database
	// sql = select * from Employeeinfo where name = 'Rilwan'
	ResultSet rs = s.executeQuery("select * from Employeeinfo where name = 'Rilwan'");
	// By deafault rs will point to base index only. No value is present in base index
	
	//rs.next();     // This will move rs from base index to first index
	
	while (rs.next())      // while rs.next is present, then go and pick the value
		{	
		// Now get the username and password from Name Rilwan
		System.out.println(rs.getString("username"));
		System.out.println(rs.getString("password"));
		}
	
	// We can inject this values into selenium code by using sendkeys		
	}
}