package Servlet;

import JDBC.MySQLConnection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by xiangang.wei on 2016/10/19.
 */
@javax.servlet.annotation.WebServlet(name = "process")
public class process extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        String author = new String(request.getParameter("author").getBytes("ISO-8859-1"), "UTF-8");
        String title = new String(request.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String time = simpleDateFormat.format(new Date());
        String content = new String(request.getParameter("content").getBytes("ISO-8859-1"), "UTF-8");

        //连接数据库
        MySQLConnection mySQLConnection = new MySQLConnection();
        System.out.println(mySQLConnection.connectDatabase());

        //创建SQL插入语句
        String sqlInsert = "insert into message(author,title,time,content) values('" + author + "','" +
                title + "','" + time + "','" + content + "')";

        //插入数据库
        if (mySQLConnection.insert(sqlInsert)) {
            System.out.println("数据插入成功！");
        } else {
            System.out.println("数据插入失败！");
        }

        //关闭数据库连接
        mySQLConnection.close();

        response.sendRedirect("showMessage.jsp");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
