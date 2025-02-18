package com.captcha.servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class register extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    int n = 0;
    try {

      response.setContentType("text");
      Connection con = DriverManager.getConnection("jdbc:h2:~/captcha-db", "admin", "password");

      String mail = request.getParameter("mail");
      String password = request.getParameter("password");
      PrintWriter out = response.getWriter();
      Statement st = con.createStatement();
      ResultSet rst = st.executeQuery("select * from users where username=" + "\'" + mail + "\'");
      if (rst.next()) {

        out.println("<html><head><script>alert('already user email exists');</script></head></html>");
        response.sendRedirect("index_1.html");
      } else {
        String s = "insert into users (username, password) values(?,?)";
        PreparedStatement ps = con.prepareStatement(s);
        ps.setString(1, mail);
        ps.setString(2, password);

        n = ps.executeUpdate();
        if (n != 0) {
          out.println("<html><head><script>alert('registration successful');</script></head></html>");
          response.sendRedirect("index_1.html");
        } else {
          out.println("<html><head><script>alert('registration unsuccessful');</script></head></html>");
          response.sendRedirect("index_1.html");
        }
      }
    } catch (Exception e) {
      PrintWriter out = response.getWriter();
      out.println("alert(" + e + ");");
    }
  }
}