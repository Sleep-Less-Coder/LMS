package grabdata;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectDB;

public class SearchBorrower {
	public static void srch(int card_no) throws SQLException
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
			rs = stmt.executeQuery("SELECT * FROM borrower WHERE card_no LIKE '" + card_no +"%'");
			
			StringBuffer buffer = new StringBuffer();

			//Check if there is any data in the result set.
			if (!rs.isBeforeFirst() ) {    
				 System.out.println("No data"); 
			}
			else{
				//Print the titles
				System.out.println("Card_No\t Name\t Address\t Phone\n");
			}
			
			while(rs.next()){
				
				//Clear the buffer
				buffer.delete(0, buffer.length());
				
				//Print the columns 
				buffer.append(rs.getInt("card_no"));
				buffer.append("\t");
				buffer.append(rs.getString("name"));
				buffer.append("\t");
				buffer.append(rs.getString("Address"));
				buffer.append("\t");
				buffer.append(rs.getLong("Phone"));
				buffer.append("\t");
				System.out.println(buffer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//Close connection
			if(conn != null) conn.close();
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
	}

}
