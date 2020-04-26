package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AvoidSQLWarnDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
		String host="localhost";
		String port= "3306";
		String url = "jdbc:mysql://"+host+":"+port+"/employeeportal?" + "autoReconnect=true&useSSL=false";
		String user =  "root";
		String password = "Rodmanraylex1";
		
		Connection con = DriverManager.getConnection(url,user, password);
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from Employeeinfo where name = 'Rahmon'");
		
		while (rs.next())      // while rs.next is present, then go and pick the value
		{	
		// Now get the username and password from Name Rahmon
		System.out.println(rs.getString("username"));
		System.out.println(rs.getString("password"));
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\jdbcConnection\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();

		driver.get("https://login.salesforce.com");

		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));

		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));
		}
		
// We can inject this values into selenium code by using sendkeys		

	}

}
