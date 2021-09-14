package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateProfileServlet", value = "/update-profile")
public class UpdateProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User userlog = (User) request.getSession().getAttribute("user");
        if (request.getSession().getAttribute("passupdate") != null) {
            String success = request.getParameter("success");
            request.setAttribute("success", success);
            System.out.println("Suceessfully updated password." + success);

        }
        if (request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("intendedpage", "profile");
            response.sendRedirect("/login");
            return;
        }

        request.setAttribute("username", userlog.getUsername());
        request.setAttribute("email", userlog.getEmail());

        request.getRequestDispatcher("/WEB-INF/update-profile.jsp").forward(request, response);
        request.removeAttribute("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User currentUser = (User) request.getSession().getAttribute("user");

        String newUsername = request.getParameter("username");
        String newEmail = request.getParameter("email");

        DaoFactory.getUsersDao().updateUserInfo(newUsername, newEmail, currentUser.getUsername());
        currentUser.setEmail(newEmail);
        currentUser.setUsername(newUsername);
       request.getSession().setAttribute("user", currentUser);
        response.sendRedirect("/profile");
    }
}
