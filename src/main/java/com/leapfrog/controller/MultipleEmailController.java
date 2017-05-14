/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.controller;

import com.leapfrog.lfaproject.dao.EventDAO;
import com.leapfrog.lfaproject.dao.impl.EventDAOImpl;
import com.leapfrog.lfaproject.entity.Event;
import com.leapfrog.lfaproject.entity.SendEmail;
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
@WebServlet(name = "multipleEmailController", urlPatterns = {"/multipleEmailController/*"})
public class MultipleEmailController extends Controller {
    SendEmail sendEmail=new SendEmail();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EventDAO eventDAO = new EventDAOImpl();
        int eventid = Integer.parseInt(request.getParameter("id"));
        try {
            Event e = eventDAO.getById(eventid);
            request.setAttribute("event", e);

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/invite/InviteAllAtOnce.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id=(Integer)request.getSession(false).getAttribute("loggedin");
        int event_id = Integer.parseInt(request.getParameter("eventid"));
        String from=request.getParameter("from");
        String subject=request.getParameter("subject");
        String message=request.getParameter("message");
        System.out.println(event_id);
        
        System.out.println("hi");
        boolean confirm=request.getParameter("confirm")!=null?true:false;
        SendEmail sendEmail=new SendEmail();
        sendEmail.setFrom(from);
        sendEmail.setSubject(subject);
        sendEmail.setBody(message);
        sendEmail.setHost("smtp.wlink.com.np");
        sendEmail.sendMultipleMessage(user_id, event_id, confirm);
      
        
        

    }

}
