package LibrarianActions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dto.Librarian;
import Dto.Student;
import Util.jdbcUtil;

public class reglog extends AdapterClass {

	Connection con=null;
	PreparedStatement pst=null;
	
	public String Studentreg(Student student) {
		int msg=0;
		try {
			con=jdbcUtil.jdbcconnection();
			pst=con.prepareStatement("insert into student(name,branch,conno,email,password) values(?,?,?,?,?)");
			pst.setString(1, student.getName());
			pst.setString(2, student.getBranch());
			pst.setLong(3, student.getContactno());
			pst.setString(4, student.getEmail());
			pst.setString(5,student.getPassword());
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
			return "failed";
		}
	}

	@Override
	public String Studentlog(String email, String password) {
		ResultSet result=null;
		String ps=null;
		String msg = "failed";
		try {
			con=jdbcUtil.jdbcconnection();
			pst=con.prepareStatement("select password from student where email=?");
			pst.setString(1, email);
			 result=pst.executeQuery();
			result.next();
			ps=result.getString(1);
			System.out.println(ps);
		
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
		if(ps!=null) {
			if(password.equals(ps)) {
				msg="success";
			}
		}	
		System.out.println(msg);
		return msg;
		}


	@Override
	public String Librarianreg(Librarian L) {
		int msg=0;
		try {
			con=jdbcUtil.jdbcconnection();
			pst=con.prepareStatement("insert into librarian values(?,?,?,?)");
			pst.setString(1, L.getName());
			pst.setString(2, L.getEmail());
			pst.setString(3, L.getPassword());
			pst.setLong(4, L.getConno());
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
			return "failed";
		}
	}

	@Override
	public String Librarianlog(String email, String password) {
		ResultSet result=null;
		String ps=null;
		String msg="failed";
		try {
			con=jdbcUtil.jdbcconnection();
			pst=con.prepareStatement("select password from librarian where email=?");
			pst.setString(1, email);
			 result=pst.executeQuery();
			result.next();
			ps=result.getString(1);
			
		
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
		if(ps!=null) {
			if(password.equals(ps)) {
				msg="success";
			}
		}	
		System.out.println(msg);
		return msg;
	}
	

}
