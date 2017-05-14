/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.dao;

import com.leapfrog.lfaproject.entity.Email;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface EmailDAO {
    int insert(Email email) throws SQLException, ClassNotFoundException;
    int delete(int id)throws SQLException, ClassNotFoundException;
    int update(int id)throws SQLException, ClassNotFoundException;
    List<Email> getAll(int userid)throws SQLException, ClassNotFoundException;
    Email getById(int id) throws SQLException, ClassNotFoundException;
    
}
