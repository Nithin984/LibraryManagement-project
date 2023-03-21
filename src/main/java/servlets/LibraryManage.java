package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.Book;
import LibrarianActions.Controller;
import LibrarianActions.LibrarianActions;

@WebServlet("/LibraryManage/*")
public class LibraryManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book b=null;
		PrintWriter out=response.getWriter();
		Controller c=new Controller();
		LibrarianActions B=c.BookManage();
		out.println("<head>\r\n"
				+ "<style>\r\n"
				+ "h1 {text-align: center;}\r\n"
				+ "p {text-align: center;}\r\n"
				+ "div {text-align: center;}\r\n"
				+ "</style>\r\n"
				+ "</head>");
		
		if(request.getRequestURI().endsWith("addform")) {
		
			
			String msg=B.addbook(request.getParameter("Book Name"),request.getParameter("Author Name"),request.getParameter("Subject"), Integer.parseInt(request.getParameter("quantity")));
			if(msg.equalsIgnoreCase("success")) {
				out.println("<h1> Book Added Succesfully</h1>");
			}
			else {
				out.println("<h1> Book is not added</h1>");
			}
		}
		if(request.getRequestURI().endsWith("deleteform")) {
			String msg=B.deletebook(Integer.parseInt(request.getParameter("Book_id")));
			if(msg.equalsIgnoreCase("success")) {
				out.println("<h1 style=color:green> Book is deleted</h1>");
			}
			else {
				out.println("<h1 style=color:red> Book is not deleted</h1>");
			}
		}
		if(request.getRequestURI().endsWith("updateform")) {
			Book book=new Book();
			book.setBid(Integer.parseInt(request.getParameter("Book id")));
			book.setName(request.getParameter("Book Name"));
			book.setAuthor(request.getParameter("Author Name"));
			book.setSubject(request.getParameter("Subject"));
			book.setCount(Integer.parseInt(request.getParameter("quantity")));
			String msg=B.updatebook(book);
			
			if(msg.equalsIgnoreCase("success")) {
				out.println("<h1 style=color:green> Book is updated</h1>");
			}
			else {
				out.println("<h1 style=color:red> Book is not updated</h1>");
			}
		}
		
		if(request.getRequestURI().endsWith("searchform")) {
			b=B.searchbook(Integer.parseInt(request.getParameter("Book_id")));
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
			out.print("<table >\r\n"
					+ "  <thead>\r\n"
					+ "    <tr>\r\n"
					+ "      <th scope=\"col\">Book Id</th>\r\n"
					+ "      <th scope=\"col\">Book Name</th>\r\n"
					+ "      <th scope=\"col\">Author</th>\r\n"
					+ "      <th scope=\"col\">subject</th>\r\n"
					+ "      <th scope=\"col\">quantity</th>\r\n"
					+ "    </tr>\r\n"
					+ "  </thead>\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "      <td scope=\"row\">"+b.getBid()+"</td>\r\n"
					+ "      <td>"+b.getName()+"</td>\r\n"
					+ "      <td>"+b.getAuthor()+"</td>\r\n"
					+ "      <td>"+b.getSubject()+"</td>\r\n"
					+ "      <td>"+b.getCount()+"</td>\r\n"
					+ "    </tr>");
			
		}
		out.println("<form>\r\n"
				+ " <input type=\"button\"value=\"back\" style=\"background-color:#328ba8;\"onclick=\"history.back(-1)\">\r\n"
				+ "</form>");
		
	}

}
