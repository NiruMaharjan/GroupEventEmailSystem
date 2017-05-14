/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.dao;

import com.leapfrog.lfaproject.entity.EventMailList;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface EventMailListDAO {
 int insert(EventMailList eml) throws SQLException,ClassNotFoundException;
 List<EventMailList>getAll(int user_id)throws SQLException,ClassNotFoundException;
 int delete(int id)throws SQLException,ClassNotFoundException;
    
    
}
