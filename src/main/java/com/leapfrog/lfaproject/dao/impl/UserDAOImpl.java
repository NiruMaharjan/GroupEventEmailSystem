/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.dao.impl;

import com.leapfrog.lfaproject.dao.UserDAO;
import com.leapfrog.lfaproject.db.util.DbConnection;
import com.leapfrog.lfaproject.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class UserDAOImpl implements UserDAO {

    DbConnection db = new DbConnection();

    @Override
    public int insert(User u) throws SQLException, ClassNotFoundException {
        String sql = "INSERT into users(user_name,password,reactivation_code,email,status) values(?,?,?,?,?)";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, u.getName());
        stmt.setString(2, u.getPassword());
        stmt.setString(3, u.getReactivatinCode());
        stmt.setString(4, u.getEmail());
        stmt.setBoolean(5, u.isStatus());
        int result = stmt.executeUpdate();
        return result;

    }

   
    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        List<User> userList = new ArrayList<>();
        String sql = "Select *From users";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setName((rs.getString("user_name")));
            user.setPassword(rs.getString("password"));
            user.setReactivatinCode(rs.getString("reactivation_code"));
            user.setEmail(rs.getString("email"));
            user.setStatus(rs.getBoolean("status"));
            userList.add(user);

        }
        return userList;
    }
    
     @Override
    public User loginCheck(String username, String password) throws SQLException, ClassNotFoundException {
        for(User u:getAll()){
            if(u.getName().equalsIgnoreCase(username)&&u.getPassword().equalsIgnoreCase(password)){
                return u;
            }
        }
        return null;
    }

    @Override
    public User getById(int id) throws SQLException, ClassNotFoundException {
        User user=null;
        String sql="Select *From users where user_id=?";
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs=stmt.executeQuery();
        while(rs.next()){
            user=new User();
            user.setId(rs.getInt("user_id"));
            user.setName(rs.getString("user_name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setReactivatinCode(rs.getString("reactivation_code"));
            user.setStatus(rs.getBoolean("status"));
        }
        return user;
    }


}
