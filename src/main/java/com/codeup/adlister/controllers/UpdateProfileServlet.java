package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Form;

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
        if (request.getSession().getAttribute("updateError") != null) {
            request.setAttribute("error", request.getSession().getAttribute("updateError"));
            System.out.println("Update username error alerted.");
        }

        request.setAttribute("username", userlog.getUsername());
        request.setAttribute("email", userlog.getEmail());

        request.getRequestDispatcher("/WEB-INF/update-profile.jsp").forward(request, response);
        request.removeAttribute("success");
        request.removeAttribute("error");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User currentUser = (User) request.getSession().getAttribute("user");

        String newUsername = request.getParameter("username");
        String newEmail = request.getParameter("email");

        boolean invalidInput = Form.usernameIsTaken(newUsername);

        if (invalidInput) {
            request.getSession().setAttribute("updateError", "That username is taken.");
            response.sendRedirect("/update-profile");
        } else {
            DaoFactory.getUsersDao().updateUserInfo(newUsername, newEmail, currentUser.getUsername());
            currentUser.setEmail(newEmail);
            currentUser.setUsername(newUsername);
            request.getSession().setAttribute("user", currentUser);
            response.sendRedirect("/profile");
        }
    }
}
