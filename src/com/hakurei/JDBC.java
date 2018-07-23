package com.hakurei;

import java.sql.*;

public class JDBC {
    private String driverName = "com.mysql.cj.jdbc.Driver";//驱动名称
    private String dbURL = "jdbc:mysql://127.0.0.1:3306/";//数据库路径
    private String configure="?serverTimezone=UTC&useSSL=false";
    private String userName = "root";//用户名
    private String userPwd = "0123456789as";//密码
    private Connection dbConn;//连接数据库使用的对象
    private Statement stmt;//和数据库通信使用的对象
    private ResultSet rs;//返回结果

    public JDBC(String url)
    {
        dbURL+=url;
    }
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
    public  ResultSet getResultSet()
    {
        return rs;
    }


    //初始化
    public void init()
    {

        try {
            Class.forName(driverName);//装载该类
            dbURL+=configure;
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);//连接数据库
            stmt=dbConn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //执行查询 结果保存在rs里
    public void query(String sql)
    {
        try{
            rs=stmt.executeQuery(sql);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    //执行删除插入更新语句
    public void update(String sql){
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
