package JDBC;
import java.sql.*;
/**
 * Created by xiangang.wei on 2016/10/20.
 */
public class MySQLConnection {
    private String dbdriver = "org.gjt.mm.mysql.Driver";
    private String url = "jdbc:mysql://localhost:3306/messageboard";
    private String user = "root";
    private String password = "root";
    private Connection connection =null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public boolean connectDatabase(){
        try {
            Class.forName(dbdriver);
        }catch (ClassNotFoundException e){
            System.out.println("没有找到"+dbdriver+"相关的类文件！");
            return false;
        }

        try{
            connection = DriverManager.getConnection(url,user,password);
        }catch (SQLException e){
            System.out.println("连接数据库失败！");
            return false;
        }

        try{
            statement = connection.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean operation(String sql){
        int flag;
        try{
            flag = statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        if (flag>0)
            return true;
        else
            return false;
    }

    public boolean delete(String sql){
        return operation(sql);
    }

    public boolean update(String sql){
        return operation(sql);
    }

    public boolean insert(String sql){
        return operation(sql);
    }

    public ResultSet query(String sql){
        try{
            resultSet = statement.executeQuery(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }

    public void close(){
        try{
            statement.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
