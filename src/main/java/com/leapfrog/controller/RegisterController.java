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
@WebServlet(name="register" ,urlPatterns={"/register"})
public class RegisterController extends Controller {

    UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/register/register.jsp");
        rd.forward(request, response);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");
        String code = request.getParameter("code");
        String email = request.getParameter("email");
        boolean status = ((request.getParameter("status") != null) ? true : false);
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        user.setReactivatinCode(code);
        user.setEmail(email);
        user.setStatus(status);
        if (cpassword.equalsIgnoreCase(password) && status) {
            try {
                userDAO.insert(user);
                response.sendRedirect(request.getContextPath()+"/login");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

}
