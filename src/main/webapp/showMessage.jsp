<%@ page import="java.util.ArrayList" %>
<%@ page import="JavaBean.Message" %><%--
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
    ArrayList<Message> messageArrayList = (ArrayList<Message>) application.getAttribute("messageList");
    if (messageArrayList == null || messageArrayList.size() == 0) {
%>
<p>没有留言可以显示！</p>
    <%
      } else {
    %>
<table>
    <%
        for (Message mm : messageArrayList) {
    %>
    <tr>
        <td>留 言 者：</td>
        <td>
            <%= mm.getAuthor()%>
        </td>
    </tr>
    <tr>
        <td>留言标题：</td>
        <td>
            <%= mm.getTitle()%>
        </td>
    </tr>
    <tr>
        <td>留言时间：</td>
        <td>
            <%= mm.getTime()%>
        </td>
    </tr>
    <tr>
        <td>留言内容：</td>
        <td>
                <textarea name="content" rows="10" cols="50">
                    <%= mm.getContent()%>
                </textarea>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
