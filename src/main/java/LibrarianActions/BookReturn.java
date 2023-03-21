package LibrarianActions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import Util.jdbcUtil;

public class BookReturn extends AdapterClass{

Connection con=null;
PreparedStatement pst=null;

	public int returnbook(int sid,int bid) {
		int row=0;
		int row1=0;
		int fine=0;
		int days=0;
		try {
			con=jdbcUtil.jdbcconnection();
		
			LocalDate date=LocalDate.now();
			pst=con.prepareStatement("update issuerecord set returndate=?,status=? where sid=? and bid=? and status='pending'");
			pst.setDate(1, Date.valueOf(date));
			pst.setString(2, "returned");
			pst.setInt(3, sid);
			pst.setInt(4, bid);
		PreparedStatement pst1=con.prepareStatement("update library set quantity=quantity+1 where bid=?");
		pst1.setInt(1, bid);
		 row1=pst1.executeUpdate();
		System.out.println(row);
		System.out.println(row1);

		row=pst.executeUpdate();
		PreparedStatement pst2=con.prepareStatement("select datediff(returndate,issuedate) from issuerecord where sid=? and bid=? and status='returned'");
		pst2.setInt(1, sid);
		pst2.setInt(2, bid);
		ResultSet r=pst2.executeQuery();
		
		if(row!=0&&row1!=0) {
			System.out.println("book returned succesfully");
		
		while(r.next()) {
			days=r.getInt(1);
		}
			
			System.out.println(days);
			
		}
		else {
			days=-1;
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
		return days;
		
	}

}
