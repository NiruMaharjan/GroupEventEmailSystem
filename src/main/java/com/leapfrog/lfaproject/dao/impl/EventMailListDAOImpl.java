/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.dao.impl;

import com.leapfrog.lfaproject.dao.EventMailListDAO;
import com.leapfrog.lfaproject.db.util.DbConnection;
import com.leapfrog.lfaproject.entity.Email;
import com.leapfrog.lfaproject.entity.Event;
import com.leapfrog.lfaproject.entity.EventMailList;
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
public class EventMailListDAOImpl implements EventMailListDAO {

    DbConnection db = new DbConnection();

    @Override
    public int insert(EventMailList eml) throws SQLException, ClassNotFoundException {
        String sql = "Insert into event_mail_list(event_id,mail_id,confirm,user_id) values(?,?,?,?)";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, eml.getEvent().getId());
        stmt.setInt(2, eml.getEmail().getId());
        stmt.setBoolean(3, eml.isConfirm());
        stmt.setInt(4, eml.getUser().getId());
        int result = stmt.executeUpdate();
        return result;

    }

    @Override
    public List<EventMailList> getAll(int user_id) throws SQLException, ClassNotFoundException {
        List<EventMailList> eventMailList = new ArrayList<>();
        String sql = "select * from event_mail_list eml"
                + " join  events e on e.event_id=eml.event_id "
                + "join mail_list ml on ml.mail_id=eml.mail_id "
                + "join  users u on u.user_id=eml.user_id "
                + "where eml.user_id=?";

        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, user_id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            EventMailList eml = new EventMailList();
            eml.setId(rs.getInt("eventmail_id"));
            Event event = new Event();
            event.setId(rs.getInt("event_id"));
            event.setTitle(rs.getString("title"));
            eml.setEvent(event);
            Email email = new Email();
            email.setEmail_id(sql);
            email.setEmail_id(rs.getString("email"));
            eml.setEmail(email);
            eml.setInvite_date(rs.getDate("invite_date"));
            eml.setConfirm(rs.getBoolean("confirm"));
            eventMailList.add(eml);
        }
        return eventMailList;

    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
