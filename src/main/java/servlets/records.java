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

import Util.jdbcUtil;

@WebServlet("/records/*")
public class records extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
		Connection con=null;
	ResultSet r=null;
	PreparedStatement pst=null;
	out.println("<head>\r\n"
			+ "<style>\r\n"
			+ "table{\r\n"
			+ "width:70%;\r\n"
			+ "margin:auto;\r\n"
			+ "border-collapse:collapse;\r\n"
			+ "border:1px solid;\r\n"
			+ "}\r\n"
			+ "th{\r\n"
			+ "    text-align: left;\r\n"
			+ "    padding: 1.0909em 3px;\r\n"
			+ "    background-color: #66D3BA;\r\n"
			+ "}\r\n"
			+ "th,td{\r\n"
			+ "border:1px solid;\r\n"
			+" padding:7px;\r\n"
			+ "}\r\n"
			+ "</style>\r\n"
			+ "</head>");
		if(request.getRequestURI().endsWith("allrecords")) {
			try {
				con=jdbcUtil.jdbcconnection();
				pst=con.prepareStatement("select * from issuerecord");
				r=pst.executeQuery();
				out.println("<h1 style=color:blue;> All records</h1>");
				out.print("<table border='1'class=\"table\">\r\n"
						+ "  <thead>\r\n"
						+ "    <tr>\r\n"
						+ "      <th scope=\"col\">Student id</th>\r\n"
						+ "      <th scope=\"col\">Student name</th>\r\n"
						+ "      <th scope=\"col\">Book id</th>\r\n"
						+ "      <th scope=\"col\">Book name</th>\r\n"
						+ "      <th scope=\"col\">Issue Date</th>\r\n"
						+ "      <th scope=\"col\">Return Date</th>\r\n"
						+ "      <th scope=\"col\">Status</th>\r\n"
						+ "    </tr>");
				while(r.next()) {
					
					out.println("</thead>\r\n"
							+ "  <tbody>\r\n"
							+ "    <tr>\r\n"
							+ "      <td scope=\"row\">"+r.getInt(1)+"</td>\r\n"
							+ "      <td>"+r.getString(2)+"</td>\r\n"
							+ "      <td>"+r.getInt(3)+"</td>\r\n"
							+ "      <td>"+r.getString(4)+"</td>\r\n"
							+ "      <td>"+r.getDate(5)+"</td>\r\n"
						    + "      <td>"+r.getDate(6)+"</td>\r\n"
						    + "      <td>"+r.getString(7)+"</td>\r\n"
							+ "    </tr>");
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
			
			
			
		}
		if(request.getRequestURI().endsWith("pendingrecords")) {
			try {
				con=jdbcUtil.jdbcconnection();
				pst=con.prepareStatement("select * from issuerecord where status='pending'");
				r=pst.executeQuery();
				out.println("<h1 style=color:red;> pending records</h1>");
				
				if(r!=null) {
				out.print("<table border='1'class=\"table\">\r\n"
						+ "  <thead>\r\n"
						+ "    <tr>\r\n"
						+ "      <th scope=\"col\">Student id</th>\r\n"
						+ "      <th scope=\"col\">Student name</th>\r\n"
						+ "      <th scope=\"col\">Book id</th>\r\n"
						+ "      <th scope=\"col\">Book name</th>\r\n"
						+ "      <th scope=\"col\">Issue Date</th>\r\n"
						+ "    </tr>");
				
				
				while(r.next()) {
					
					out.println("</thead>\r\n"
							+ "  <tbody>\r\n"
							+ "    <tr>\r\n"
							+ "      <td scope=\"row\">"+r.getInt(1)+"</td>\r\n"
							+ "      <td>"+r.getString(2)+"</td>\r\n"
							+ "      <td>"+r.getInt(3)+"</td>\r\n"
							+ "      <td>"+r.getString(4)+"</td>\r\n"
							+ "      <td>"+r.getDate(5)+"</td>\r\n"
							+ "    </tr>");
				}
				}
				
				
				else {
					out.println("<h1> NO pending records</h1>");
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
			
			
			
		}
		if(request.getRequestURI().endsWith("returnedrecords")) {
			try {
				con=jdbcUtil.jdbcconnection();
				pst=con.prepareStatement("select * from issuerecord where status='returned'");
				r=pst.executeQuery();
				out.println("<h1 style=color:green;> Returned records</h1>");
				out.print("<table border='1'class=\"table\">\r\n"
						+ "  <thead>\r\n"
						+ "    <tr>\r\n"
						+ "      <th scope=\"col\">Student id</th>\r\n"
						+ "      <th scope=\"col\">Student name</th>\r\n"
						+ "      <th scope=\"col\">Book id</th>\r\n"
						+ "      <th scope=\"col\">Book name</th>\r\n"
						+ "      <th scope=\"col\">Issue Date</th>\r\n"
						+ "      <th scope=\"col\">Returned Date</th>\r\n"
						+ "    </tr>");
				while(r.next()) {
					
					out.println("</thead>\r\n"
							+ "  <tbody>\r\n"
							+ "    <tr>\r\n"
							+ "      <td scope=\"row\">"+r.getInt(1)+"</td>\r\n"
							+ "      <td>"+r.getString(2)+"</td>\r\n"
							+ "      <td>"+r.getInt(3)+"</td>\r\n"
							+ "      <td>"+r.getString(4)+"</td>\r\n"
							+ "      <td>"+r.getDate(5)+"</td>\r\n"
							+ "      <td>"+r.getDate(6)+"</td>\r\n"
							+ "    </tr>");
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
			
			
			
		}
		out.println("<form>\r\n"
				+ " <input type=\"button\"value=\"back\" style=\"background-color:#328ba8;\"onclick=\"history.back()\">\r\n"
				+ "</form>");
		
		
	}
}
