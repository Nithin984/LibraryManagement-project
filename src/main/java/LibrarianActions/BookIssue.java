package LibrarianActions;

import java.util.Scanner;

import Util.jdbcUtil;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class BookIssue extends AdapterClass {
Connection con=null;
PreparedStatement pst=null;
ResultSet result=null;
	Scanner s=new Scanner(System.in);
	public String issuebook(int sid,int bid){
	int row=0;
	LocalDate date=LocalDate.now();
	int g = 7;
	
	

	try {
		con=jdbcUtil.jdbcconnection();
		PreparedStatement pst4=con.prepareStatement("select count(*) from issuerecord where sid=? and status='pending';");
		pst4.setInt(1,sid);
		ResultSet t=pst4.executeQuery();
		t.next();
		g=t.getInt(1);
		if(g<3) {
		PreparedStatement pst1=con.prepareStatement("select name from student where sid=?");
		pst1.setInt(1, sid);
		ResultSet re=pst1.executeQuery();
		re.next();
		String sname=re.getString(1);
		PreparedStatement pst2=con.prepareStatement("select name from library where bid=? ");
		pst2.setInt(1, bid);
		ResultSet re1=pst2.executeQuery();
		re1.next();
		String bname=re1.getString(1);
		PreparedStatement pst3=con.prepareStatement("update library set quantity=quantity-1 where bid=?");
		pst3.setInt(1, bid);
		pst3.executeUpdate();
		pst=con.prepareStatement("insert into issuerecord(sid,sname,bid,bname,issuedate,status) values(?,?,?,?,?,?)");
		pst.setInt(1, sid);
		pst.setString(2,sname );
		pst.setInt(3, bid);
		pst.setString(4, bname);
		pst.setDate(5,Date.valueOf(date));
		pst.setString(6, "pending");
		 row=pst.executeUpdate();
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
	if(row==1) {
		return "success";
	}
	if(g>=3) {
		return "exceeded";
	}
	else {
		return "Book issue failed";
	}
			
	}
}
