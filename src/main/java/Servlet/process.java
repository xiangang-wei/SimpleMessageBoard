package Servlet;

import JavaBean.Message;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by xiangang.wei on 2016/10/19.
 */
@javax.servlet.annotation.WebServlet(name = "process")
public class process extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Message message = new Message();
        message.setAuthor(new String(request.getParameter("author").getBytes("ISO-8859-1"),"UTF-8"));
        message.setTitle(new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String time = simpleDateFormat.format(new Date());
        message.setTime(time);
        message.setContent(new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8"));


        HttpSession session = request.getSession();
        ServletContext sxc = session.getServletContext();
        ArrayList<Message> messageList = (ArrayList<Message>) sxc.getAttribute("messageList");
        if (messageList == null){
             messageList = new ArrayList<Message>();
        }
        messageList.add(message);
        sxc.setAttribute("messageList",messageList);
        response.sendRedirect("showMessage.jsp");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
