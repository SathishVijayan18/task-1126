package mysqlAndLog4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.xdevapi.JsonArray;

public class ListLogic {
		
	static Logger log=Logger.getLogger(Employee.class.getName());
	
	public static void list_emp(int empType) throws JSONException {
	if(empType==1) {
		try {
			Hashtable ht1=new Hashtable();
			Connection con = JdbcConnect.connectDB();
			String sql="select * from permanent_time_emp";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()) {
				//int empid=rs.getInt("EMP_ID");
				//int empcode=rs.getInt("EMP_CODE");
				//String empname=rs.getString("EMP_NAME");
				//int empsalary=rs.getInt("SALARY");
				//ht1.put("id",empid);
				ht1.put("Empcode",rs.getInt("EMP_CODE"));
				ht1.put("EmpName",rs.getString("EMP_NAME"));
				ht1.put("EmpSalary",rs.getInt("SALARY"));	
				String output=ht1.toString();
				//System.out.println(output);
				
				Gson gson =new GsonBuilder().disableHtmlEscaping().create();
				String jsonString = gson.toJson(ht1);
				System.out.println(jsonString);
				
				//JSONArray jarray=new JSONArray(jsonString);
				//System.out.println(jarray);
			}
	
		}
			catch (SQLException e) {
			e.printStackTrace();
		}
	}else if(empType==2) {
		try {
			Hashtable ht1=new Hashtable();
			Connection con = JdbcConnect.connectDB();
			String sql="select * from part_time_emp";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ht1.put("Empcode",rs.getInt("EMP_CODE"));
				ht1.put("EmpName",rs.getString("EMP_NAME"));
				ht1.put("EmpSalary",rs.getInt("SALARY"));	
				String output=ht1.toString();
				//System.out.println(output);
				
				Gson gson =new GsonBuilder().disableHtmlEscaping().create();
				String jsonString = gson.toJson(ht1);
				System.out.println(jsonString);
			}
	
		}
			catch (SQLException e) {
			e.printStackTrace();
		}
	}else if(empType==3) {
		try {
			Hashtable ht1=new Hashtable();
			Connection con = JdbcConnect.connectDB();
			String sql="select * from contract_emp";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ht1.put("Empcode",rs.getInt("EMP_CODE"));
				ht1.put("EmpName",rs.getString("EMP_NAME"));
				ht1.put("EmpSalary",rs.getInt("SALARY"));	
				String output=ht1.toString();
				//System.out.println(output);
				
				Gson gson =new GsonBuilder().disableHtmlEscaping().create();
				String jsonString = gson.toJson(ht1);
				System.out.println(jsonString);
			}
	
		}
			catch (SQLException e) {
			e.printStackTrace();
		}
	}else {
		log.warn("Invalid Entry");
	}
		
		
	}
	public static void listPart_time_emp(int empType) {
		try {
			Connection con = JdbcConnect.connectDB();
			String sql="select * from part_time_emp where EMP_ID=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())  { 
				System.out.println(rs.getInt("EMP_ID")+" "+rs.getString("EMP_NAME")+" "+rs.getInt("SALARY")+" "+rs.getInt("EMP_CODE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void listContract_emp(int empType) {
		try {
			Connection con = JdbcConnect.connectDB();
			String sql="select * from contract_emp";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())  { 
				System.out.println(rs.getInt("EMP_ID")+" "+rs.getString("EMP_NAME")+" "+rs.getInt("SALARY")+" "+rs.getInt("EMP_CODE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void show_emp(int empid,int emptype) throws Exception {
		try {
			Hashtable ht1=new Hashtable();
			Connection con = JdbcConnect.connectDB();
			if(emptype==1) {
				String output="";
				String sql="select * from permanent_emp where EMP_ID=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,empid);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					ht1.put("Empcode",rs.getInt("EMP_CODE"));
					ht1.put("EmpName",rs.getString("EMP_NAME"));
					ht1.put("EmpSalary",rs.getInt("SALARY"));	
					output=ht1.toString();
					}
				System.out.println(output);
			}else if(emptype==2) {
				String output="";
				String sql="select * from part_time_emp where EMP_ID=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,empid);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					ht1.put("Empcode",rs.getInt("EMP_CODE"));
					ht1.put("EmpName",rs.getString("EMP_NAME"));
					ht1.put("EmpSalary",rs.getInt("SALARY"));	
					output=ht1.toString();
				}System.out.println(output);
			}else if(emptype==3) {
				String output="";
				String sql="select * from contract_emp where EMP_ID=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,empid);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					ht1.put("Empcode",rs.getInt("EMP_CODE"));
					ht1.put("EmpName",rs.getString("EMP_NAME"));
					ht1.put("EmpSalary",rs.getInt("SALARY"));	
					output=ht1.toString();
				}System.out.println(output);
			}else
			{
				log.warn("Invalid entry");
			}
		}
			catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
