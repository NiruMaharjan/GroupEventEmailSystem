 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.dao.impl;

import com.leapfrog.lfaproject.dao.EmailDAO;
import com.leapfrog.lfaproject.db.util.DbConnection;
import com.leapfrog.lfaproject.entity.Email;
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
public class EmailDAOImpl implements EmailDAO {

    DbConnection db = new DbConnection();

    @Override
    public int insert(Email email) throws SQLException, ClassNotFoundException {
        String sql = "Insert into mail_list(name,email,user_id) values(?,?,?)";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, email.getName());
        stmt.setString(2, email.getEmail_id());

        stmt.setInt(3, email.getUser().getId());
        int result = stmt.executeUpdate();
        return result;

    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Email> getAll(int userid) throws SQLException, ClassNotFoundException {
        List<Email> emailList = new ArrayList<>();
        db.open();
        String sql = "Select *From mail_list where user_id=?";
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, userid);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Email email = new Email();
            email.setId(rs.getInt("mail_id"));
            email.setName(rs.getString("name"));
            email.setEmail_id(rs.getString("email"));
            User user = new User();
            user.setId(rs.getInt("user_id"));
            email.setUser(user);
            emailList.add(email);
        }
        return emailList;

    }

    @Override
    public Email getById(int id) throws SQLException, ClassNotFoundException {
        Email email = null;
        String sql = "Select *From mail_list where mail_id=?";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            email = new Email();
            email.setId(rs.getInt("mail_id"));
            email.setName(rs.getString("name"));
            email.setEmail_id(rs.getString("email"));
            User user = new User();
            user.setId(rs.getInt("user_id"));
            email.setUser(user);

        }
        return email;
    }

}
