package database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//
/**
 * 1.Create Connection
 *2.Create Statement
 *3.Execute statement
 *4.Close connection
 */
public class JDBCExample1 
{
	public static void main(String[] args) throws SQLException
	{
		//Step-1:Creating Connection
		//"jdbc:oracle:thin:@localhost:1521/MaheshOracle","hr","Aanvi01#" --->Called as Connection Stream
		//jdbc:oracle:thin --->Syntax
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/MaheshOracle","hr","Aanvi01#");
		
		//Step-2:Create Statement
		Statement stmt=con.createStatement();
		
		//Step-3:Execute sql Statement
		//String s="INSERT INTO customers (NAME, AGE, SALARY, STATE) VALUES ('MAHESH','29','500000','KARNATAKA')";
		//String s="SELECT * FROM customers";
		//String s="SELECT NAME, AGE FROM customers";
		String s="DELETE FROM customers WHERE NAME='MAHESH'";
		//String s="UPDATE customers SET NAME='Mahesh'";
		//String s="DELETE FROM CUSTOMERS";
		/*String s="INSERT ALL INTO CUSTOMERS (NAME, AGE, SALARY, STATE) VALUES ('RAMESH', '30', '300000', 'KARNATAKA')"
				+"INTO CUSTOMERS (NAME, AGE, SALARY, STATE) VALUES ('SURESH', '34', '400000', 'TAMIL NADU')"
				+ "SELECT * FROM DUAL";*/

		stmt.execute(s);
		
		//Step-4:Close Connection
		con.close();
		System.out.println("Connection Closed");
	}
}
