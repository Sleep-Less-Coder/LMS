package grabdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectDB;

public class ListTransactionHistory {
	public static void list(int isbn) throws SQLException
	{
		/* Vars */
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			/* Get Connection */
			conn = ConnectDB.getConnection();
			stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY	
					);
			
			/* Execute query */
			rs = stmt.executeQuery("SELECT * FROM book_borrow WHERE isbn = "+ isbn +"");
			StringBuffer buffer = new StringBuffer();

			//Check if there is any data in the result set.
			if (!rs.isBeforeFirst() ) {    
				 System.out.println("No data"); 
			}
			else{
				//Print the titles
				System.out.println("ISBN\t Card_no\t Borrow_date\tReturned\tReturn_date");
			}
			
			while(rs.next()){
				
				//Clear the buffer
				buffer.delete(0, buffer.length());
				
				//Print the columns 
				buffer.append(rs.getInt("isbn"));
				buffer.append("\t");
				buffer.append(rs.getInt("card_no"));
				buffer.append("\t");
				buffer.append(rs.getString("borrow_date"));
				buffer.append("\t");
				buffer.append(rs.getString("returned"));
				buffer.append("\t");
				buffer.append(rs.getString("return_date"));
				buffer.append("\t");
				System.out.println(buffer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//Close connections
			if(conn != null) conn.close();
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
	}
}
