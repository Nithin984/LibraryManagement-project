package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import LibrarianActions.Controller;
import LibrarianActions.LibrarianActions;


@WebFilter("/test1")
public class studentFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String msg="invalid username or password";
		PrintWriter out=response.getWriter();
		Controller c=new Controller();
		LibrarianActions S=c.log();
		String message=S.Studentlog(request.getParameter("user_id"), request.getParameter("password"));
		if(message.equalsIgnoreCase("success")) {
				chain.doFilter(request, response);
		}
		
		
		else {
			out.print("<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n"
					+ "    <link rel=\"stylesheet\" href=\"styles2.css\">\r\n"
					+ "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n"
					+ "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n"
					+ "    <link href=\"https://fonts.googleapis.com/css2?family=Arimo&display=swap\" rel=\"stylesheet\">\r\n"
					+ "    <script src=\"https://kit.fontawesome.com/11bc3c9fe9.js\" crossorigin=\"anonymous\"></script>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "    \r\n"
					+ "    <div class=\"parent\">\r\n"
					+ "        <div class=\"form-container\">\r\n"
					+ "            <header class=\"h1-container\">\r\n"
					+ "                <h1>Ineuron library management system</h1>\r\n"
					+ "                <a href=\"admin.html\">\r\n"
					+ "                    Admin Login\r\n"
					+ "                    <i class=\"fa-solid fa-arrow-right\"></i>\r\n"
					+ "                </a>\r\n"
					+ "            </header>\r\n"
					+ "<!---------------------            form start here ----------------------------------------------------------------->\r\n"
					+ "            <form       method=\"post\"   action=\"./test1\">\r\n"
					+ "            <p style=\"text-align: center; color: red; margin-bottom: 15px;\"> "+msg+""
					+ "                <div class=\"container-box\">\r\n"
					+ "                    <input type=\"text\" required name=\"user_id\">\r\n"
					+ "                    <label for=\"\">user id</label>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"container-box\">\r\n"
					+ "                    <input type=\"password\" required name=\"password\">\r\n"
					+ "                    <label for=\"\">password</label>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"container-box\">\r\n"
					+ "                    <button type=\"submit\">Login</button>\r\n"
					+ "                </div>\r\n"
					+ "                \r\n"
					+ "            </form>\r\n"
					+ "<!----------------------------------             form end Here ------------------------------------------------------>\r\n"
					+ "            <p>\r\n"
					+ "                <a href=\"student_reg.html\">\r\n"
					+ "                    New user? Register Here\r\n"
					+ "                </a>\r\n"
					+ "            </p>\r\n"
					+ "        </div>\r\n"
					+ "        <div class=\"child_2\">\r\n"
					+ "            <p>Student Login</p>\r\n"
					+ "\r\n"
					+ "        </div>\r\n"
					+ "    </div>\r\n"
					+ "    \r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "");
		}
	}



}
