package LibrarianActions;

import java.io.IOException;
import java.sql.*;
import Dto.Book;
import Util.jdbcUtil;
public class BookManage extends AdapterClass{

	
	Connection con=null;
	PreparedStatement pst=null;
	@Override
	public String addbook(String name,String Author,String subject,int quantity) {
	
		int message=0;
		try {
			con=jdbcUtil.jdbcconnection();
			PreparedStatement pst=con.prepareStatement("insert into library(name,author,subject,quantity)values(?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2,Author);
			pst.setString(3, subject);
			pst.setInt(4, quantity);
			 message=pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		if(message==1) {
	         return "success"; 
				}
				else {
					return "failed";
				}

	}

	@Override
	public String deletebook(int bid){
		int row=0;
		
		try {
			con=jdbcUtil.jdbcconnection();
			pst=con.prepareStatement("delete from library where bid=?");
			pst.setInt(1, bid);
			row=pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(row==1) {
			return "success";
		}
		else {
			return "failed";
		}

	}

	@Override
	public String updatebook(Book Book) {
		int row=0;
	
		try {
			con=jdbcUtil.jdbcconnection();
			pst=con.prepareStatement("update library set name=?,author=?,subject=?,quantity=? where bid=?");
			pst.setString(1, Book.getName());
			pst.setString(2, Book.getAuthor());
			pst.setString(3, Book.getSubject());
			pst.setInt(4, Book.getCount());
			pst.setInt(5, Book.getBid());
			 row=pst.executeUpdate();

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(row==1) {
			return "success";
		}
		else {
			return "failed";
		}

	}

	@Override
	public Book searchbook(int bid){
				Book b=null;
		try {
			con=jdbcUtil.jdbcconnection();
			pst=con.prepareStatement("select * from library where bid=?");
			pst.setInt(1, bid);
			ResultSet result=pst.executeQuery();
		if(b==null) {
			if(result.next()) {
				b=new Book();
				b.setName(result.getString(1));
				b.setAuthor(result.getString(2));
				b.setSubject(result.getString(3));
				b.setBid(result.getInt(5));
		
				 
			}
			
			
		}
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
		
	}


}
