/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.controller;

import com.leapfrog.lfaproject.dao.EmailDAO;
import com.leapfrog.lfaproject.dao.EventDAO;
import com.leapfrog.lfaproject.dao.EventMailListDAO;
import com.leapfrog.lfaproject.dao.impl.EmailDAOImpl;
import com.leapfrog.lfaproject.dao.impl.EventDAOImpl;
import com.leapfrog.lfaproject.dao.impl.EventMailListDAOImpl;
import com.leapfrog.lfaproject.entity.SendEmail;
import com.leapfrog.lfaproject.entity.Email;
import com.leapfrog.lfaproject.entity.Event;
import com.leapfrog.lfaproject.entity.EventMailList;
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
@WebServlet(name = "event", urlPatterns = {"/event/*"})
public class EventController extends Controller {

    EventDAO eventDAO = new EventDAOImpl();
    EmailDAO emailDAO = new EmailDAOImpl();
    EventMailListDAO emlDAO = new EventMailListDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPage = "/WEB-INF/view/events/index.jsp";
        boolean redirect = false;

        try {
            String path = request.getRequestURI();
            //System.out.println("Path:"+path);
            if (path.contains("/add")) {
                viewPage = "/WEB-INF/view/events/add.jsp";
                //System.out.println("Path value"+path);
            } else if (path.contains("/edit")) {
                if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Event event = eventDAO.getById(id);
                    if (event == null) {
                        redirect = true;
                        response.sendRedirect(request.getContextPath() + "/event");
                    }
                    request.setAttribute("event", event);
                } else {
                    redirect = true;
                    response.sendRedirect(request.getContextPath() + "/event");
                }

                viewPage = "/WEB-INF/view/events/edit.jsp";

            }
            else if(path.contains("/delete")){
                redirect=true;
                if(request.getParameter("id")!=null && !request.getParameter("id").isEmpty()){
                    int id=Integer.parseInt(request.getParameter("id"));
                    int result=eventDAO.delete(id);
                    if(result>0){
                        response.sendRedirect(request.getContextPath()+"/event");
                    }
                }
            }

            int userid = (Integer) request.getSession(false).getAttribute("loggedin");
            request.setAttribute("events", eventDAO.getAll(userid));

            //request.getSession().getAttribute("loggedin");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        if (!redirect) {
            RequestDispatcher rd = request.getRequestDispatcher(viewPage);
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();

        String title = request.getParameter("eventname");
        String description = request.getParameter("description");
        String startDate = request.getParameter("startdate");
        String endDate = request.getParameter("enddate");

        boolean invite = ((request.getParameter("invite") != null) ? true : false);
        boolean status = ((request.getParameter("status") != null) ? true : false);
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        User user = new User();
        user.setId(user_id);
        Event e = new Event();
        e.setTitle(title);
        e.setDescription(description);
        e.setStart_date(startDate);
        e.setEnd_date(endDate);
        e.setInvite(invite);
        e.setStatus(status);
        e.setUser(user);
        try {
            if (request.getParameter("event_id") == null || request.getParameter("event_id").isEmpty()) {
                eventDAO.insert(e);
                System.out.println("event added");
            } else {
                int id = Integer.parseInt(request.getParameter("event_id"));
                e.setId(id);
                eventDAO.update(e);
            }

            response.sendRedirect(request.getContextPath() + "/event");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
