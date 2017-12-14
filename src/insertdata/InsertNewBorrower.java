package insertdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectDB;

public class InsertNewBorrower {

	public static void insertData(int borrower_card_no_insert, String borrower_name_insert, String borrower_address_insert, int borrower_phone_insert) throws SQLException
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
			rs = stmt.executeQuery("INSERT INTO borrower VALUES("+ borrower_card_no_insert +" , '"+ borrower_name_insert +"', '"+ borrower_address_insert +"', "+ borrower_phone_insert +")");
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
