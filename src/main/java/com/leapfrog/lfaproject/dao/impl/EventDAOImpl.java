/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.dao.impl;

import com.leapfrog.lfaproject.dao.EventDAO;
import com.leapfrog.lfaproject.db.util.DbConnection;
import com.leapfrog.lfaproject.entity.Event;
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
public class EventDAOImpl implements EventDAO {

    DbConnection db = new DbConnection();

    @Override
    public List<Event> getAll(int userid) throws SQLException, ClassNotFoundException {
        List<Event> eventList = new ArrayList<>();
        String sql = "SELECT *FROM events join users ON users.user_id=events.user_id where users.user_id=?";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, userid);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Event event = new Event();
            event.setId(rs.getInt("event_id"));
            event.setTitle(rs.getString("title"));
            event.setDescription(rs.getString("description"));
            event.setAdded_date(rs.getDate("added_date"));
            event.setStart_date(rs.getString("start_date"));
            event.setEnd_date(rs.getString("end_date"));
            event.setInvite(rs.getBoolean("invite"));
            event.setStatus(rs.getBoolean("status"));
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setName(rs.getString("user_name"));
            user.setPassword(rs.getString("password"));
            user.setReactivatinCode(rs.getString("reactivation_code"));
            user.setEmail(rs.getString("email"));
            user.setStatus(rs.getBoolean("status"));
            event.setUser(user);
            eventList.add(event);

        }
        return eventList;

    }

    @Override
    public int insert(Event e) throws SQLException, ClassNotFoundException {
        String sql = "Insert into events(title,description,start_date,end_date,invite,status,user_id) values(?,?,?,?,?,?,?)";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, e.getTitle());
        stmt.setString(2, e.getDescription());
        stmt.setString(3, e.getStart_date());
        stmt.setString(4, e.getEnd_date());
        stmt.setBoolean(5, e.isInvite());
        stmt.setBoolean(6, e.isStatus());
        stmt.setInt(7, e.getUser().getId());

        int result = stmt.executeUpdate();
        return result;

    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        String sql="Delete from events where event_id=?";
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setInt(1, id);
        int result=stmt.executeUpdate();
        return result;
        
        
    }

    @Override
    public int update(Event e) throws SQLException, ClassNotFoundException {
        String sql="Update events set title=?,description=?,start_date=?,end_date=?,invite=?,status=? where event_id=?";;
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setString(1, e.getTitle());
        stmt.setString(2,e.getDescription());
        stmt.setString(3, e.getStart_date());
        stmt.setString(4,e.getEnd_date());
        stmt.setBoolean(5, e.isStatus());
        stmt.setBoolean(6,e.isInvite());
        stmt.setInt(7,e.getId());
        int result=stmt.executeUpdate();
        return result;
        
    }

    @Override
    public Event getById(int id) throws SQLException, ClassNotFoundException {
        Event event = null;
        String sql = "Select *From events where event_id=?";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            event = new Event();
            event.setId(rs.getInt("event_id"));
            event.setTitle(rs.getString("title"));
            event.setDescription(rs.getString("description"));
            event.setStart_date(rs.getString("start_date"));
            event.setEnd_date(rs.getString("end_date"));
            event.setInvite(rs.getBoolean("invite"));
            event.setStatus(rs.getBoolean("status"));
        }
        return event;
    }

}
