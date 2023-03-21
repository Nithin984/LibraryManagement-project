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

@WebServlet("/view/*")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
		System.out.println(request.getRequestURI());
	
		Connection con=null;
		ResultSet b=null;
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
		if(request.getRequestURI().endsWith("allbooks")) {
			
		try {
			con=jdbcUtil.jdbcconnection();
			pst=con.prepareStatement("select * from library");
			b=pst.executeQuery();
		
			out.print("<table>\r\n"
					+ "  <thead>\r\n"
					+ "    <tr>\r\n"
					+ "      <th scope=\"col\">Book Id</th>\r\n"
					+ "      <th scope=\"col\">Book Name</th>\r\n"
					+ "      <th scope=\"col\">Author</th>\r\n"
					+ "      <th scope=\"col\">subject</th>\r\n"
					+ "      <th scope=\"col\">quantity</th>\r\n"
					+ "    </tr>");
			while(b.next()) {
					out.println("</thead>\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td scope=\"row\">"+b.getInt(5)+"</td>\r\n"
					+ "      <td>"+b.getString(1)+"</td>\r\n"
					+ "      <td>"+b.getString(2)+"</td>\r\n"
					+ "      <td>"+b.getString(3)+"</td>\r\n"
					+ "      <td>"+b.getInt(4)+"</td>\r\n"
					+ "    </tr>"
					
					);
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
		
		if(request.getRequestURI().endsWith("allstudents")) {
			try {
				con=jdbcUtil.jdbcconnection();
				pst=con.prepareStatement("select * from student");
				b=pst.executeQuery();
				out.print("<table border='1'class=\"table\">");
				out.print("  <thead>\r\n"
						+ "    <tr>\r\n"
						+ "      <th scope=\"col\">Student Id</th>\r\n"
						+ "      <th scope=\"col\">Student Name</th>\r\n"
						+ "      <th scope=\"col\">Branch</th>\r\n"
						+ "      <th scope=\"col\">contact no</th>\r\n"
						+ "      <th scope=\"col\">Email</th>\r\n"
						+ "    </tr>");
				while(b.next()) {
						out.println("</thead>\r\n"
						+ "  <tbody>\r\n"
						+ "    <tr>\r\n"
						+ "      <td scope=\"row\">"+b.getInt(1)+"</td>\r\n"
						+ "      <td>"+b.getString(2)+"</td>\r\n"
						+ "      <td>"+b.getString(3)+"</td>\r\n"
						+ "      <td>"+b.getLong(4)+"</td>\r\n"
						+ "      <td>"+b.getString(5)+"</td>\r\n"
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
	


