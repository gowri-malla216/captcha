package com.captcha.servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class login extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    try {
      Connection con = DriverManager.getConnection("jdbc:h2:~/captcha-db", "admin", "password");
      response.setContentType("text/html");

      String mail = request.getParameter("mail");
      String pwd = request.getParameter("password");
      Statement st = con.createStatement();
      ResultSet rst = st.executeQuery("select * from users where username=" + "\'" + mail + "\'");
      rst.next();

      if (pwd.equals(rst.getString(2))) {
        HttpSession session = request.getSession();
        session.setAttribute("mail", mail);
        response.sendRedirect("index.html");
      } else {
        response.sendRedirect("index_1.html");
      }
    } catch (Exception e) {
      PrintWriter out = response.getWriter();
      out.println("<html><head><script>alert(" + e + ");</script></head></html>");
    }
  }
}