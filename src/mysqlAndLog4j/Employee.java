package mysqlAndLog4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Employee
{ 
	static Logger log=Logger.getLogger(Employee.class.getName());
	
	public static void InputData() throws Exception {
		Scanner s1=new Scanner(System.in);
		System.out.println("1.CREATE");
		System.out.println("2.UPDATE");
		System.out.println("3.DELETE");
		System.out.println("4.LIST");
		System.out.print("Enter the operation : ");
		int i=s1.nextInt();
		switch(i) {
		case 1:
			insertData();
			break;
		case 2:
			updateData();
			break;
		case 3:
			removeData();
			break;
		case 4:
			fetchData();
			break;
		default:
			log.warn("Invalid Entry");
		}
	}
	public static void insertData() throws Exception
	{
		PreparedStatement ps;
		Scanner s1=new Scanner(System.in);
		try {
		Connection con=JdbcConnect.connectDB();
		System.out.println("Please Provide Details...");
		System.out.print("Enter Emp_id : ");
		int id=s1.nextInt();
		System.out.print("Enter Emp_name : ");
		String name=s1.next();
		System.out.print("Enter Salary : ");
		int salary=s1.nextInt();
		System.out.print("Enter Emp_code: ");
		int emp_code=s1.nextInt();
		System.out.println("Select Employee type 1.Permanent emp 2.part time emp 3.Contract emp");
		int empType=s1.nextInt();
	if(empType<4 && empType>0) {

		if(empType==1) {
			ps=con.prepareStatement("INSERT INTO permanent_emp VALUES ('"+id+"','"+name+"','"+salary+"','"+emp_code+"')");
			ps.executeUpdate();
			//System.out.println("data inserted");
			log.info("Data Inserted");
		}else if(empType==2){
			ps=con.prepareStatement("INSERT INTO part_time_emp VALUES ('"+id+"','"+name+"','"+salary+"','"+emp_code+"')");
			ps.executeUpdate();
			//System.out.println("data inserted");
			log.info("Data Inserted");
		}else if(empType==2003) {
			ps=con.prepareStatement("INSERT INTO  VALUES contract_emp ('"+id+"','"+name+"','"+salary+"','"+emp_code+"')");
			ps.executeUpdate();
			//System.out.println("data inserted");
			log.info("Data Inserted");
		}else
		{
			log.warn("invalid entry");;
		}
	}
	else {
		log.warn("Number should be 1 to 3");
	}
	con.close();
	}
		catch(Exception e) {
			log.trace(e);
		}
	}
	public static void updateData() throws Exception
	{
		Scanner s2=new Scanner(System.in);
		System.out.println("Enter id: ");
		int id=s2.nextInt();
		int changeId=id;
		System.out.println("Select Employee type  : 1.permanent_emp 2.part time emp 3.contract_emp");
		System.out.println("Enter Emp_type : ");
		int emptypeInput=s2.nextInt();
		if(emptypeInput>0 && emptypeInput<4) {
		try {
			Connection con=JdbcConnect.connectDB(); 
			
			System.out.println("1.EMP_NAME | 2.SALARY | 3.EMP_CODE");
			System.out.print("Enter field : ");
			int input=s2.nextInt();
			
			switch(input) {
			case 1:
				UpdateLogic.updateName(changeId,emptypeInput);
				break;
			case 2:
				UpdateLogic.updateSalary(changeId,emptypeInput);
				break;
			case 3:
				UpdateLogic.updateEmpcode(changeId,emptypeInput);
				break;
			default:
				log.warn("Invalid Entry");
			}
			con.close();
		}
		catch(Exception e) {
			log.trace(e);
		}
		}
		else
		{
			log.warn("Invalid Emp_type");
		}
	}
	public static void removeData() throws Exception
	{
		Scanner s3=new Scanner(System.in);
		System.out.println("Enter id : ");
		int id=s3.nextInt();	
		System.out.println("Select Employee type  : 1.permanent_emp 2.part time emp 3.contract_emp");
		int empType=s3.nextInt();
		if(empType>0 && empType<4) {
		DeleteLogic.RemoveService(id,empType);
		}
	}
	public static void fetchData() throws Exception {
		Scanner s4=new Scanner(System.in);
		System.out.println("1.List Particular employee || 2.List all");
		int input1=s4.nextInt();
		if(input1==1) {
			System.out.println("Enter emp_id : ");
			int input2=s4.nextInt();
			System.out.println("Enter emp_type : ");
			int input3=s4.nextInt();
			ListLogic.show_emp(input2, input3);
		}
		else if(input1==2) {
			System.out.println("select employee table : 1.permanent_emp 2.part_time_emp 3.contract_emp");
			int emptype=s4.nextInt();
			
		if(emptype>0 && emptype<4) {
			if(emptype==1) {
				ListLogic.list_emp(emptype);
			}else if(emptype==2){
				ListLogic.list_emp(emptype);
			}else if(emptype==3){
				ListLogic.list_emp(emptype);
			}
			else {
				log.warn("Invalid entry");
				}
			}
			else {
				log.warn("Number should be less than 0");
			}
		}
	
	}
	
	public static void main(String args[]) throws Exception
	{
		
		InputData();
	}
}