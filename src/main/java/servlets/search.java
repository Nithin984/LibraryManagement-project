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


@WebServlet("/search/*")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet r=null;
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
		out.print("<table>\r\n"
				+ "  <thead>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"col\">Book Id</th>\r\n"
				+ "      <th scope=\"col\">Book Name</th>\r\n"
				+ "      <th scope=\"col\">Author</th>\r\n"
				+ "      <th scope=\"col\">subject</th>\r\n"
				+ "      <th scope=\"col\">quantity</th>\r\n"
				+ "    </tr>");
		if(request.getRequestURI().endsWith("name"))
		{
			boolean flag=false;
			String Bname=request.getParameter("book name");
			try {
				con=jdbcUtil.jdbcconnection();
				pst=con.prepareStatement("select * from library");
				r=pst.executeQuery();
				while(r.next()) {
					
					String n=r.getString(1);
					String a=r.getString(2);
					String s=r.getString(3);
					if(n.equalsIgnoreCase(Bname)||n.startsWith(Bname)||n.endsWith(Bname)||a.equalsIgnoreCase(Bname)||
							a.startsWith(Bname)||a.endsWith(Bname)||s.equalsIgnoreCase(Bname)||s.startsWith(Bname)||s.endsWith(Bname)) {
						flag=true;
						out.println("</thead>\r\n"
								+ "  <tbody>\r\n"
								+ "    <tr>\r\n"
								+ "      <td scope=\"row\">"+r.getInt(5)+"</td>\r\n"
								+ "      <td>"+r.getString(1)+"</td>\r\n"
								+ "      <td>"+r.getString(2)+"</td>\r\n"
								+ "      <td>"+r.getString(3)+"</td>\r\n"
								+ "      <td>"+r.getInt(4)+"</td>\r\n"
								+ "    </tr>");

						
					}
				}
				if(flag==false) {
					out.println("<h1 style='color:red;'>No Results Found by :"+Bname+"</h1>");
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
