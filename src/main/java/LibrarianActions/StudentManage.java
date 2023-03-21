package LibrarianActions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Dto.Student;
import Util.jdbcUtil;

public class StudentManage extends AdapterClass {
Scanner s=new Scanner(System.in);
Connection con=null;
PreparedStatement pst=null;
ResultSet result=null;
	@Override
	public String  deletestudent(int sid){
       int msg=0;
	try {
		con=jdbcUtil.jdbcconnection();
		pst=con.prepareStatement("delete from student where sid=?");
		pst.setInt(1, sid);
		msg=pst.executeUpdate();
		
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
	if(msg==1) {
		return "success";
		
	}
	else {
	return "student not deleted";
	}
	}

	@Override
	public String updatestudent(Student student){
		int msg=0;
				try {
			con=jdbcUtil.jdbcconnection();
			pst=con.prepareStatement("update student set name=?,branch=?,conno=?,email=? where sid=?");
			pst.setString(1, student.getName());
			pst.setString(2, student.getBranch());
			pst.setLong(3, student.getContactno());
			pst.setInt(5, student.getSid());
			pst.setString(4, student.getEmail());
			msg=pst.executeUpdate();
			
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
				if(msg==1) {
					return "success";
				}else {
					return "student updation failed";
				}
		
	}

	@Override
	public Student searchstudent(int sid) {
	
	Student std=null;
	try {
		con=jdbcUtil.jdbcconnection();
		pst=con.prepareStatement("select * from student where sid=?");
		pst.setInt(1,sid);
		result=pst.executeQuery();
		if(std==null) {
			if(result.next()) {
				std=new Student();
				
				std.setName(result.getString(2));
				std.setBranch(result.getString(3));
				std.setContactno(result.getLong(4));
				std.setEmail(result.getString(5));
				std.setSid(sid);
			
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
	return std;
	
	}

	
}
