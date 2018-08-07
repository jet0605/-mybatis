package com.example.writemybaits.util;

import com.example.writemybaits.domain.User;

import java.sql.*;

public class SimpleExcutor implements Excutor{

    @Override
    public <T> T query(String sql, Object parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection();
        try{
            PreparedStatement pre = connection.prepareStatement(sql);
            String str = (String) parameter;
            pre.setInt(1,Integer.parseInt(str));
            ResultSet set = pre.executeQuery();
            User user = new User();
            while(set.next()){
                user.setName(set.getString(2));
                //System.out.println(set.getString(2));
            }
            return (T)user;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private Connection getConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://120.78.149.145:3306/springbootdb?useUnicode=true&characterEncoding=utf8&useSSL=false";
        String username = "root";
        String password = "cui8135130";
        try{
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("连接成功");
            return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
