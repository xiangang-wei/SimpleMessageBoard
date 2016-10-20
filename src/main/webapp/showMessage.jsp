<%@ page import="java.util.ArrayList" %>
<%@ page import="JavaBean.Message" %>
<%@ page import="JDBC.MySQLConnection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: xiangang.wei
  Date: 2016/10/19
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>查看留言！</title>
    <style type="text/css">
        body {
            background-color: paleturquoise;
        }
    </style>
</head>
<body>

<%
    String sqlQuery = "select * from message";
    ResultSet resultSet = null;
    MySQLConnection mysqlConnection = new MySQLConnection();
    if (!mysqlConnection.connectDatabase()) {
        out.println("<h5>无法连接数据库！</h5>");
    } else {
        if ((resultSet = mysqlConnection.query(sqlQuery)) == null) {
            out.println("<h5>数据库没有数据可以显示！</h5>");
        } else {
%>
<table>
    <%
               try{
                   while(resultSet.next()){
                       out.println("<tr><td>留 言 者</td><td>"+resultSet.getString("author")+"</td></tr>");
                       out.println("<tr><td>留言标题</td><td>"+resultSet.getString("title")+"</td></tr>");
                       out.println("<tr><td>留言时间</td><td>"+resultSet.getString("time")+"</td></tr>");
                       out.println("<tr><td>留言内容</td><td><textarea name=\"content\" rows=\"10\" cols=\"50\">"+
                               resultSet.getString("content")+"</textarea></td></tr>");
                   }
               }catch (SQLException e){
                   e.printStackTrace();
               }
            }
        }
        mysqlConnection.close();
    %>
</table>
</body>
</html>
