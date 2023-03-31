package in.ashokit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import in.ashokit.util.ConnectionFactory;

public class BookDAO {

	public boolean deleteBook(int bookId, String bookName, double price) throws Exception {
           Class.forName("com.mysql.jdbc.Driver");
		Connection con = ConnectionFactory.getConnection();

		PreparedStatement pstmt = con.prepareStatement("insert into book values(?,?,?)");
		pstmt.setInt(1, bookId);
		pstmt.setString(2, bookName);
		pstmt.setDouble(3, price);

		int count = pstmt.executeUpdate();

		con.close();
		return count > 0;
	}
}
