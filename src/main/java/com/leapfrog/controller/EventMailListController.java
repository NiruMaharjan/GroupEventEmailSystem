/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.controller;

import com.leapfrog.lfaproject.dao.EventMailListDAO;
import com.leapfrog.lfaproject.dao.impl.EventMailListDAOImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name="emaillistcontroller",urlPatterns ={"/eventmaillistcontroller/*"} )
public class EventMailListController extends Controller{
    EventMailListDAO emlDAO=new EventMailListDAOImpl();
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int userid=(Integer)request.getSession(false).getAttribute("loggedin");
        try{
        request.setAttribute("eventmaillist", emlDAO.getAll(userid));
        }
        catch(SQLException|ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        
         RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/eventmaillist/EventMailList.jsp");
        rd.forward(request, response);///notice the difference of dispatcheing request  up and down.yo dispatch sabbhanda last ma garnu parcha
    }
    
    
    
}
