/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.dao;

import com.leapfrog.lfaproject.entity.Event;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface EventDAO {
    List<Event> getAll(int userid) throws SQLException,ClassNotFoundException;
    int insert(Event e) throws SQLException,ClassNotFoundException;
    int delete(int id) throws SQLException,ClassNotFoundException;
    int update(Event e) throws SQLException,ClassNotFoundException;
    Event getById(int id)throws SQLException,ClassNotFoundException;
    
    
}
