package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Librarian;
import Dto.Student;
import LibrarianActions.Controller;
import LibrarianActions.LibrarianActions;
import Util.jdbcUtil;

@WebServlet("/registration/*")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet r=null;
		PrintWriter out=response.getWriter();
		out.println("<head>\r\n"
				+ "<style>\r\n"
				+ "h1 {text-align: center;}\r\n"
				+ "p {text-align: center;}\r\n"
				+ "div {text-align: center;}\r\n"
				+ "</style>\r\n"
				+ "</head>");
		Controller c=new Controller();
		if(request.getRequestURI().endsWith("student")) {
			Student std=new Student();
			std.setName(request.getParameter("name"));
			std.setBranch(request.getParameter("branch"));
			std.setPassword(request.getParameter("password"));
            std.setEmail(request.getParameter("email"));
            std.setContactno(Long.parseLong(request.getParameter("conno")));
			LibrarianActions Reg=c.log();
			String msg=Reg.Studentreg(std);
			int id=0;
			if(msg.equalsIgnoreCase("success")) {
				try {
					con=jdbcUtil.jdbcconnection();
					pst=con.prepareStatement("select sid from student where name=? and branch=? and password=? and email=?");
					pst.setString(1,std.getName());
					pst.setString(2, std.getBranch());
					pst.setString(3, std.getPassword());
					pst.setString(4, std.getEmail());
					r=pst.executeQuery();
					r.next();
					id=r.getInt(1);
					
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
				out.print("<h1 style=color:green> REGISTRATION SUCCESSFUL</h1>");
				out.print("<h1 style=color:blue> YOUR ID IS "+id+"</h1>");
			}
			else {
				out.print("<h1 style=color:red> REGISTRATION FAILED</h1>");
			}
		}
		if(request.getRequestURI().endsWith("Librarian")) {
			Librarian lib=new Librarian();
			lib.setName(request.getParameter("name"));
			lib.setPassword(request.getParameter("password"));
            lib.setEmail(request.getParameter("email"));
            lib.setConno(Long.parseLong(request.getParameter("conno")));
			LibrarianActions Reg=c.log();
			String msg=Reg.Librarianreg(lib);
			if(msg.equalsIgnoreCase("success")) {
				out.print("<h1 style=color:green;> REGISTRATION SUCCESSFUL</h1>");
			}
			else {
				out.print("<h1 style=color:red;> REGISTRATION FAILED</h1>");
			}
			
		}
		
	}

}
