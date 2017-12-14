package insertdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectDB;

public class InsertNewBook {

	public static void insertData(int isbn, String title, int publisher_id, int author_id, String publish_date, int available_copies) throws SQLException
	{
		//Vars
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			//Get connection
			conn = ConnectDB.getConnection();
			stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY	
					);
			
			//Execute query
			rs = stmt.executeQuery("INSERT INTO BOOK VALUES("+ isbn +" , '"+ title +"', "+ publisher_id +", "+ author_id +", to_date('"+ publish_date +"', 'mm-dd-yyyy'), " + available_copies + ")");
			if(rs.next())
			{
				System.out.println("\n Inserted!");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//Close connections
			if(conn != null) conn.close();
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
	}
}
