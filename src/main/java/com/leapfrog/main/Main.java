/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.main;

import com.leapfrog.lfaproject.dao.EmailDAO;
import com.leapfrog.lfaproject.dao.EventDAO;
import com.leapfrog.lfaproject.dao.EventMailListDAO;
import com.leapfrog.lfaproject.dao.impl.EmailDAOImpl;
import com.leapfrog.lfaproject.dao.impl.EventDAOImpl;
import com.leapfrog.lfaproject.dao.impl.EventMailListDAOImpl;
import com.leapfrog.lfaproject.entity.Email;
import com.leapfrog.lfaproject.entity.Event;
import com.leapfrog.lfaproject.entity.EventMailList;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//       EmailDAO emailDAO=new EmailDAOImpl();
//       for(Email email:emailDAO.getAll(1)){
//         System.out.println(email.getName());
//     } 
       
//        EventDAO eventDAO=new EventDAOImpl();
//        for(Event event:eventDAO.getAll(1)){
//            System.out.println(event.getDescription());
//        }
        EventMailListDAO emlDAO=new EventMailListDAOImpl();
        
        for(EventMailList eml:emlDAO.getAll(1)){
            System.out.println(eml.getId());
            System.out.println(eml.getEvent().getTitle());
            System.out.println(eml.getEmail().getEmail_id());
        }
        
        
    }
}
