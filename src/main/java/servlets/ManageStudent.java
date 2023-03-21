package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Student;
import LibrarianActions.Controller;
import LibrarianActions.LibrarianActions;

@WebServlet("/ManageStudent/*")
public class ManageStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Student std=new Student();
		Controller c=new Controller();
		LibrarianActions S=c.StudentManage();
		out.println("<head>\r\n"
				+ "<style>\r\n"
				+ "h1 {text-align: center;}\r\n"
				+ "p {text-align: center;}\r\n"
				+ "div {text-align: center;}\r\n"
				+ "</style>\r\n"
				+ "</head>");
		if(request.getRequestURI().endsWith("updateform")) {
			std.setSid(Integer.parseInt(request.getParameter("Student id")));
			std.setName(request.getParameter("Student Name"));
			std.setBranch(request.getParameter("Branch Name"));
			std.setContactno(Long.parseLong(request.getParameter("Conno")));
			std.setEmail(request.getParameter("email"));
			String msg=S.updatestudent(std);
			if(msg.equalsIgnoreCase("success")) {
				out.print("<h1 style=color:green;> Updation successfull</h1>");
			}
			else {
				out.print("<h1 style=color:red;> Updation failed</h1>");
			}
		}
		
		if(request.getRequestURI().endsWith("searchform")) {
			std=S.searchstudent(Integer.parseInt(request.getParameter("Student id")));
			if(std!=null) {
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
			out.print("<table border='1'class=\"table\">");
			out.print("  <thead>\r\n"
					+ "    <tr>\r\n"
					+ "      <th scope=\"col\">Student Id</th>\r\n"
					+ "      <th scope=\"col\">Student Name</th>\r\n"
					+ "      <th scope=\"col\">Branch</th>\r\n"
					+ "      <th scope=\"col\">contact not</th>\r\n"
					+ "      <th scope=\"col\">Email</th>\r\n"
					+ "    </tr>");
			
					out.println("</thead>\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td scope=\"row\">"+std.getSid()+"</td>\r\n"
					+ "      <td>"+std.getName()+"</td>\r\n"
					+ "      <td>"+std.getBranch()+"</td>\r\n"
					+ "      <td>"+std.getContactno()+"</td>\r\n"
					+ "      <td>"+std.getEmail()+"</td>\r\n"
					+ "    </tr>");
			}
			else {
				out.print("<h1 style=color:red;> Student not found with the id "+request.getParameter("Student id")+"</h1>");
			}
		}
		if(request.getRequestURI().endsWith("deleteform")) {
		String msg=	S.deletestudent(Integer.parseInt(request.getParameter("Student id")));
			if(msg.equalsIgnoreCase("success")) {
				out.print("<h1 style=color:green;> Student deleted</h1>");
			}
			else {
				out.print("<h1 style=color:red;> Student deletion failed</h1>");
			}
		}
		out.println("<form>\r\n"
				+ " <input type=\"button\"value=\"back\" style=\"background-color:#328ba8;\"onclick=\"history.back()\">\r\n"
				+ "</form>");
		
	}

}
