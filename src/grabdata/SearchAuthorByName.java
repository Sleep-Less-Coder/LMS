package grabdata;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectDB;

public class SearchAuthorByName {
	public static void srch(String name) throws SQLException
	{
		//Vars
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//Get cconnection
			conn = ConnectDB.getConnection();
			stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY	
					);
			
			//Execute query
			rs = stmt.executeQuery("SELECT * FROM author WHERE name LIKE '" + name +"%'");
			StringBuffer buffer = new StringBuffer();

			//Check if there is any data in the result set.
			if (!rs.isBeforeFirst() ) {    
				 System.out.println("No data"); 
			}
			else{
				//Print the titles
				System.out.println("Author_Id\t Name\t Email\t");
			}
			
			while(rs.next()){
				
				//Clear the buffer
				buffer.delete(0, buffer.length());
				
				//Print the columns 
				buffer.append(rs.getInt("author_id"));
				buffer.append("\t");
				buffer.append(rs.getString("name"));
				buffer.append("\t");
				buffer.append(rs.getString("email"));
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
