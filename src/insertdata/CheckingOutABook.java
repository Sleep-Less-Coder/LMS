package insertdata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectDB;

public class CheckingOutABook {
	public static void insertData(int isbn_book_borrow, int card_no_book_borrow, String todaysDate) throws SQLException
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
			rs = stmt.executeQuery("INSERT INTO book_borrow VALUES("+ isbn_book_borrow +" , "+ card_no_book_borrow +", to_date('"+ todaysDate +"','mm-dd-yyyy'), 'F', null)");
			if(rs.next())
			{
				//Close first stmt and open another to update available copies
				stmt.close();
				Statement stmt2 = conn.createStatement();
				stmt2.executeQuery("UPDATE book set available_copies = available_copies - 1 WHERE isbn = "+ isbn_book_borrow +"");
				System.out.println("\n Book with the ISBN no. " + isbn_book_borrow +" checked out by borrower " + card_no_book_borrow + " successfully!");
				stmt2.close();
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
