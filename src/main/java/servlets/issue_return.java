package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LibrarianActions.Controller;
import LibrarianActions.LibrarianActions;


@WebServlet("/book/*")
public class issue_return extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		PrintWriter out=response.getWriter();
		Controller c=new Controller();
		out.println("<head>\r\n"
				+ "<style>\r\n"
				+ "h1 {text-align: center;}\r\n"
				+ "p {text-align: center;}\r\n"
				+ "div {text-align: center;}\r\n"
				+ "</style>\r\n"
				+ "</head>");
		if(request.getRequestURI().endsWith("issue")) {
		LibrarianActions I=c.Issue();
		String msg=I.issuebook(Integer.parseInt(request.getParameter("student_id")),Integer.parseInt(request.getParameter("Book_id")));
		if(msg.equalsIgnoreCase("success")) {
			out.print("<h1 style=color:green;> book issue succesfull </h1>");
		}
		
		else {
			if(msg.equalsIgnoreCase("exceeded")) {
				out.print("<h1 style=color:red;>  Issue failed ...Your barrow limit exceeded </h1>");
			}else {
			out.print("<h1 style=color:red;> book/student is not available</h1>");
			}
		}
		}
		if(request.getRequestURI().endsWith("return")) {
			int fine=0;
			LibrarianActions R=c.Return();
			int days=R.returnbook(Integer.parseInt(request.getParameter("student_id")),Integer.parseInt(request.getParameter("Book_id")));
			if(days>=0) {
				if((days-15)>0) {
				fine=(days-15)*10;
				out.println("<h1 style=color:green;> book returned succesfully</h1>");
				out.println("<h1 style=color:blue;> Total  days  :: " +days+"</h1>");
				out.println("<h1 style=color:blue ;>Fine ::"+fine + "</h1>");

				}
				else {

					out.println("<h1 style=color:green;> book returned succesfully</h1>");
					out.println("<h1 style=color:blue;> Total days   :: " +days+"</h1>");
					out.println("<h1 style=color:blue;> your fine is :: "+ 0 + "</h1>");

				}
			}
			else {
				out.println("<h1 style=color:red;> book returning failed</h1>");
			}
			
			
		}
		out.println("<form>\r\n"
				+ " <input type=\"button\"value=\"back\" style=\"background-color:#328ba8;\"onclick=\"history.back()\">\r\n"
				+ "</form>");
		
		
	}

}
