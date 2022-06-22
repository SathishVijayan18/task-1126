package mysqlAndLog4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class UpdateLogic {
	static Logger log=Logger.getLogger(UpdateLogic.class.getName());
/*public static void updateId(int changeId,int emptypeInput) throws Exception{
	Connection con=JdbcConnect.connectDB();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter new Emp_id : ");
	int empid=sc.nextInt();
	String sql="update "+emptypeInput+" set EMP_ID=? where EMP_ID=?";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1, empid);
	ps.setInt(2, changeId);
	ps.executeUpdate();
	con.close();
}*/
public static void updateName(int changeId,int emptypeInput) throws Exception
{
	Connection con=JdbcConnect.connectDB();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter new Emp_Name: ");
	String empname=sc.nextLine();
	if(emptypeInput==1) {
		String sql="update permant_emp set EMP_NAME=? where EMP_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, empname);
		ps.setInt(2, changeId);
		ps.executeUpdate();
	}else if(emptypeInput==2) {
		String sql="update part_time_emp set EMP_NAME=? where EMP_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, empname);
		ps.setInt(2, changeId);
		ps.executeUpdate();
	}
	else if(emptypeInput==3) {
		String sql="update contract_emp set EMP_NAME=? where EMP_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, empname);
		ps.setInt(2, changeId);
		ps.executeUpdate();
	}
	else {
		//System.out.println("Invalid entry");
		log.warn("Invalid Entry");
	}
	con.close();
}
public static void updateSalary(int changeId,int emptypeInput) throws Exception
{
	Connection con=JdbcConnect.connectDB();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter new Salary: ");
	int sal=sc.nextInt();
	if(emptypeInput==1) {
		String sql="update permanent_emp set SALARY=? where EMP_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, sal);
		ps.setInt(2, changeId);
		ps.executeUpdate();
	}else if(emptypeInput==2) {
		String sql="update part_time_emp set SALARY=? where EMP_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, sal);
		ps.setInt(2, changeId);
		ps.executeUpdate();
	}
	else if(emptypeInput==3) {
		String sql="update contract_emp set SALARY=? where EMP_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, sal);
		ps.setInt(2, changeId);
		ps.executeUpdate();
	}
	else {
		log.warn("Invalid entry");
	}
	con.close();
}
public static void updateEmpcode(int changeId,int emptypeInput) throws Exception
{
	Connection con=JdbcConnect.connectDB();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter new Emp_code: ");
	int empcode=sc.nextInt();
	if(emptypeInput==1) {
		String sql="update contract_emp set EMP_CODE=? where EMP_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, empcode);
		ps.setInt(2, changeId);
		ps.executeUpdate();
	}else if(emptypeInput==2) {
		String sql="update contract_emp set EMP_CODE=? where EMP_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, empcode);
		ps.setInt(2, changeId);
		ps.executeUpdate();
	}
	else if(emptypeInput==3) {
		String sql="update contract_emp set EMP_CODE=? where EMP_ID=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, empcode);
		ps.setInt(2, changeId);
		ps.executeUpdate();
	}
	else {
		log.warn("Invalid entry");
	}
	con.close();
}
}
