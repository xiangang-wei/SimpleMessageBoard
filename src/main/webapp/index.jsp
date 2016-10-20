<%--
  Created by IntelliJ IDEA.
  User: xiangang.wei
  Date: 2016/10/19
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>简单留言板！</title>
    <style type="text/css">
        body {
            background-color: paleturquoise;
        }
    </style>
</head>
<body>
<div>
    <form action="process" method="post">
        <table>
            <tr>
                <td>留 言 者：</td>
                <td><input type="text" name="author"></td>
            </tr>
            <tr>
                <td>留言标题：</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>留言内容：</td>
                <td>
                <textarea name="content" rows="10" cols="50">
                </textarea>
                </td>
            </tr>
        </table>
        <input type="submit" value="提交">
        <input type="reset" value="重置">
        <a href="showMessage.jsp">查看留言!</a>
    </form>
</div>
</body>
</html>
