/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.lfaproject.dao;

import com.leapfrog.lfaproject.entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface UserDAO {
    int insert(User u)throws SQLException,ClassNotFoundException;
    List<User> getAll()throws SQLException,ClassNotFoundException;
    User loginCheck(String username,String password)throws SQLException,ClassNotFoundException;
    User getById(int id)throws SQLException,ClassNotFoundException;
    
}
