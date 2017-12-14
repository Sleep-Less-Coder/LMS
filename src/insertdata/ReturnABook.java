package insertdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectDB;

public class ReturnABook {
	public static void returnBook(int isbn_book_return, int card_no_book_return, String date_book_return, String todaysDate) throws SQLException
	{
		//vars
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
			
			rs = stmt.executeQuery("UPDATE book_borrow SET returned = 'T', return_date = to_date('"+ todaysDate +"','mm-dd-yyyy') WHERE isbn= '"+ isbn_book_return +"' AND card_no = '"+ card_no_book_return +"'");
			if(rs.next())
			{
				System.out.println("\n Book with the ISBN no. "+ isbn_book_return +" returned by "+ card_no_book_return +" borrower successfully!");
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
