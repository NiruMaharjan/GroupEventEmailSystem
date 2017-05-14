/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.controller;

import com.leapfrog.lfaproject.dao.UserDAO;
import com.leapfrog.lfaproject.dao.impl.UserDAOImpl;
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
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginController extends Controller {

    UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("hello");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/login/login.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User u = userDAO.loginCheck(username, password);

            if (u != null) {
                request.getSession().setAttribute("loggedin",u.getId());
                request.getSession().setAttribute("name", u.getName());
                request.getSession().setAttribute("useremail", u.getEmail());
               
                response.sendRedirect(request.getContextPath() + "/event");
                
                
            } else {
                response.sendRedirect(request.getContextPath() + "/login?error");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
