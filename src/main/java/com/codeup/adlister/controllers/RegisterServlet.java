package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

        request.getSession().removeAttribute("invalidregistration");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = false;
        try {
            inputHasErrors = Form.hasEmptyInputs(new String[] {username, email, password})
                    || Form.unconfirmedPassword(password, passwordConfirmation)
                    || Form.usernameIsTaken(username);
        } catch (Exception e) {
            e.printStackTrace();
            inputHasErrors = true;
        }


        if (inputHasErrors) {
            request.getSession().setAttribute("invalidregistration", true);
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username.trim(), email, password);
        DaoFactory.getUsersDao().insert(user);
        request.getSession().setAttribute("registered", true);
        response.sendRedirect("/login");
    }
}

