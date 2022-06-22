package mysqlAndLog4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DeleteLogic {
	
	static Logger log=Logger.getLogger(DeleteLogic.class.getName());
	
	public static void RemoveService(int id,int empInputType) throws SQLException {
		try {
			Connection con = JdbcConnect.connectDB();
			if(empInputType==1) {
				String sql="delete from permanent_emp where EMP_ID=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				int rs=ps.executeUpdate();
				log.info("Record was deleted");
			}
			else if(empInputType==2) {
				String sql="delete from part_time_emp where EMP_ID=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				int rs=ps.executeUpdate();
				log.info("Record was deleted");
			}else if(empInputType==3) {
				String sql="delete from contract_emp where EMP_ID=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				int rs=ps.executeUpdate();
				log.info("Record was deleted");
			}else {
				log.warn("invalid entry");
			}	
			con.close();
		} catch (SQLException e) {
			log.trace(e);
		}
	
	}
}
