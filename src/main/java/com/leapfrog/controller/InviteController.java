/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.controller;

import com.leapfrog.lfaproject.dao.EmailDAO;
import com.leapfrog.lfaproject.dao.EventDAO;
import com.leapfrog.lfaproject.dao.EventMailListDAO;
import com.leapfrog.lfaproject.dao.UserDAO;
import com.leapfrog.lfaproject.dao.impl.EmailDAOImpl;
import com.leapfrog.lfaproject.dao.impl.EventDAOImpl;
import com.leapfrog.lfaproject.dao.impl.EventMailListDAOImpl;
import com.leapfrog.lfaproject.dao.impl.UserDAOImpl;
import com.leapfrog.lfaproject.entity.Email;
import com.leapfrog.lfaproject.entity.Event;
import com.leapfrog.lfaproject.entity.EventMailList;
import com.leapfrog.lfaproject.entity.SendEmail;
import com.leapfrog.lfaproject.entity.User;
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
@WebServlet(name = "invite", urlPatterns = {"/invite/*"})
public class InviteController extends Controller {

    EmailDAO emailDAO = new EmailDAOImpl();
    EventMailListDAO emlDAO = new EventMailListDAOImpl();
    EventDAO eventDAO = new EventDAOImpl();
    UserDAO userDAO=new UserDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPage = "/WEB-INF/view/invite/Invite.jsp";
        int userid = (Integer) request.getSession(false).getAttribute("loggedin");
        try {
            
            request.setAttribute("events", eventDAO.getAll(userid));
            request.setAttribute("emails",emailDAO.getAll(userid));
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        RequestDispatcher rd = request.getRequestDispatcher(viewPage);
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id=Integer.parseInt(request.getParameter("user_id"));
        int event_id = Integer.parseInt(request.getParameter("event_id"));
        int email_id_no = Integer.parseInt(request.getParameter("email_id_no"));
        boolean confirm = (request.getParameter("confirm") != null ? true : false);
        String from = request.getParameter("from");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        try {
            Email e = emailDAO.getById(email_id_no);

            SendEmail email = new SendEmail();
            email.setFrom(from);
            email.setTo(e.getEmail_id());
            email.setSubject(subject);
            email.setBody(message);
            email.setHost("smtp.wlink.com.np");
            email.send();
            EventMailList eml = new EventMailList();
            Event event = eventDAO.getById(event_id);
            eml.setEvent(event);
            Email em = emailDAO.getById(email_id_no);
            eml.setEmail(em);
            User user=userDAO.getById(user_id);
            eml.setUser(user);
            eml.setConfirm(confirm);

            emlDAO.insert(eml);
            request.setAttribute("eventmaillist", emlDAO.getAll(user_id));
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
