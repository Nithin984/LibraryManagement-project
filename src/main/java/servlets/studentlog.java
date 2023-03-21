package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class studentlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "\r\n"
				+ "<link rel=\"stylesheet\" href=\"https://kit.fontawesome.com/11bc3c9fe9.css\" crossorigin=\"anonymous\">\r\n"
				+ "<script src=\"https://kit.fontawesome.com/11bc3c9fe9.js\" crossorigin=\"anonymous\"></script>\r\n"
				+ "<style type=\"text/css\">\r\n"
				+ "\r\n"
				+ "@import url(https://fonts.googleapis.com/css?family=Open+Sans);\r\n"
				+ "\r\n"
				+ ".box{\r\n"
				+ "  \r\n"
				+ "  font-family: 'Open Sans', sans-serif;\r\n"
				+ "  display:grid;\r\n"
				+ "  place-items:center;\r\n"
				+ " height:30vh;\r\n"
				+ "  background-color:voilet;\r\n"
				+ "      \r\n"
				+ "}\r\n"
				+ ".box1{\r\n"
				+ "height:10vh;\r\n"
				+ "display:grid;\r\n"
				+ "place-items:center;\r\n"
				+ "background-color:#a83291;\r\n"
				+ "color:white;\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "*{\r\n"
				+ "  margin:0;\r\n"
				+ "  padding:0;\r\n"
				+ "}\r\n"
				+ ".container-hold{\r\n"
				+ "  width:30%;\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".search {\r\n"
				+ "  width: 100%;\r\n"
				+ "  position: relative;\r\n"
				+ "  display: flex;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".searchTerm {\r\n"
				+ "  width: 100%;\r\n"
				+ "  border: 3px solid #00B4CC;\r\n"
				+ "  border-right: none;\r\n"
				+ "  padding: 5px;\r\n"
				+ "  height: 20px;\r\n"
				+ "  border-radius: 5px 0 0 5px;\r\n"
				+ "  outline: none;\r\n"
				+ "  color: #9DBFAF;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".searchTerm:focus{\r\n"
				+ "  color: #00B4CC;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".searchButton {\r\n"
				+ "  width: 40px;\r\n"
				+ "  height: 36px;\r\n"
				+ "  border: 1px solid #00B4CC;\r\n"
				+ "  background: #00B4CC;\r\n"
				+ "  text-align: center;\r\n"
				+ "  color: #fff;\r\n"
				+ "  border-radius: 0 5px 5px 0;\r\n"
				+ "  cursor: pointer;\r\n"
				+ "  font-size: 20px;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".wrap{\r\n"
				+ "  width: 100%;\r\n"
				+ "  margin-bottom:20px;\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "body{\r\n"
				+ "  \r\n"
				+ "      background-repeat: no-repeat;\r\n"
				+ "    background-size: cover;\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "\r\n"
				+ "<body'>\r\n"
				+ "\r\n"
				+ "<div class='box1'><h1>Ineuron Library Management</h1>\r\n"
				+ " </div>\r\n"
				+ "<div class='box'> \r\n"
				+ "<h1 style=\"color:blue;\"> Book Search</h1>\r\n"
				+ "<b>Search by Book Name or Author or Subject</b>\r\n"
				+ "<div class='container-hold'>\r\n"
				+ "\r\n"
				+ " <div class=\"wrap\">\r\n"
				+ "\r\n"
				+ "  <form  method=\"get\"  action=\"./search/name\">\r\n"
				+ "    <div class=\"search\">\r\n"
				+ "      <input type=\"text\" required name=\"book name\" class=\"searchTerm\" placeholder=\"search\">\r\n"
				+ "      <button type=\"submit\" class=\"searchButton\">\r\n"
				+ "        <i class=\"fa fa-search\"></i>\r\n"
				+ "     </button>\r\n"
				+ "   </div>\r\n"
				+ "  </form>\r\n"
				+ "</div>\r\n"
				+ "<div class=\" log-out\">\r\n"
				+ "        <p>\r\n"
				+ "          <a href=\"index.html\" class=\"log-out-a\" ><i class=\"fa-solid fa-right-from-bracket\"></i>\r\n"
				+ "            <b>Log out</b></a>\r\n"
				+ "        </p>\r\n"
				+ "      </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ " </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
	}

}