package mysqlAndLog4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {

	public static Connection con=null;
	public static String dbUrl="jdbc:mysql://db.bfsl.in:8444/employee?autoReconnect=true&characterEncoding=latin1";
	public static String userId="platformwrite";
	public static String pwd="bfslwrite";
	
	public static Connection connectDB() throws SQLException{
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");

		}
		catch(Exception e) {
			e.printStackTrace();
			}
		con=DriverManager.getConnection(dbUrl,userId,pwd);
		return con;
	}
}
