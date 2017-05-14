/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.controller;

import com.leapfrog.lfaproject.dao.EmailDAO;
import com.leapfrog.lfaproject.dao.impl.EmailDAOImpl;
import com.leapfrog.lfaproject.entity.Email;
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
@WebServlet(name = "email", urlPatterns = {"/email/*"})
public class EmailController extends Controller {
EmailDAO emailDAO=new EmailDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPage = "/WEB-INF/view/email/EmailList.jsp";

        String path = request.getRequestURI();

        if (path.contains("/addemail")) {
            System.out.println("Path value------" + path);
            viewPage = "/WEB-INF/view/email/add.jsp";
        }
        
        int userid = (Integer) request.getSession(false).getAttribute("loggedin");
        try{
         request.setAttribute("emails", emailDAO.getAll(userid));
        }
        catch(SQLException|ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            
        }
        RequestDispatcher rd = request.getRequestDispatcher(viewPage);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String name = request.getParameter("name");
            String getEmail = request.getParameter("email");
            int userId = Integer.parseInt(request.getParameter("user_id"));
            Email email = new Email();
            email.setName(name);
            email.setEmail_id(getEmail);
            User user = new User();
            user.setId(userId);
            email.setUser(user);
            try {
                emailDAO.insert(email);
                System.out.println("Email Added");
                response.sendRedirect(request.getContextPath() + "/email");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
    }

    
   
}
