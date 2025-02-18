<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    
    <body bgcolor="#E6E6FA">
        <h1 align="center"> <pre>        HELLO HUMAN     </pre> </h1>
       <h2 align="center">  !!!..we trust your not a bot..!!!   </h2>
          <%@page import="java.io.*" %>
          <%@page import="javax.servlet.*"%>
          <%@page import="javax.servlet.http.*" %>
          <% String n =(String)session.getAttribute("mail");%>
          <p>HELLO USER :<%=n%> !</p>
          <form action="index_1.html">
          <input type="submit" value="logout..!"  >
          </form>
           <% session.invalidate();%>
    </body>          
</html>