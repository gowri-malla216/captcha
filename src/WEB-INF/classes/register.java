import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class register extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
 {
  int n=0;
try{

  response.setContentType("text");
  Connection con=DriverManager.getConnection("jdbc:h2:~/captcha-db", "admin", "password");

  String mail=request.getParameter("mail");
  String password=request.getParameter("password");
  PrintWriter out=response.getWriter();
  Statement st=con.createStatement();
  st.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT, username VARCHAR(255), password VARCHAR(255), PRIMARY KEY (id))");
  ResultSet rst=st.executeQuery("select * from users where username="+"\'"+mail+"\'");
  if(rst.next()){
        
        out.println("<html><head><script>alert('already user mail exists');</script></head></html>");
        response.sendRedirect("index_1.html");
    }
  else{ 
    String s="insert into users (username, password) values(?,?)";
    PreparedStatement ps=con.prepareStatement(s);
    ps.setString(1,mail);
    ps.setString(2,password);
 
    n=ps.executeUpdate();
    if(n!=0)
    {
        out.println("<html><head><script>alert('registration successful');</script></head></html>");
      response.sendRedirect("index_1.html");
    }
    else{
     out.println("<html><head><script>alert('registration unsuccessful');</script></head></html>");
      response.sendRedirect("index_1.html");
    }
  }
}catch(Exception e)
{
PrintWriter out=response.getWriter();
out.println("alert("+e+");");
}
 }
}