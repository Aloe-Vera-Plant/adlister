package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePasswordServlet", value = "/update-password")
public class UpdatePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User currentUser = (User) request.getSession().getAttribute("user");

        User comparisonUser = DaoFactory.getUsersDao().findByUsername(currentUser.getUsername());

        String oldPasswordTest = comparisonUser.getPassword();
        String oldPasswordEntered = request.getParameter("currentPassword");

        String newPassword = request.getParameter("newPassword");
        String verifyPassword = request.getParameter("verifyPassword");

        boolean passwordsMatch = newPassword.equals(verifyPassword);
        boolean oldPasswordIsCorrect = Password.check(oldPasswordEntered, oldPasswordTest);
        boolean validInput = passwordsMatch && oldPasswordIsCorrect;

        if (validInput) {

            String hashedNewPass = Password.hash(newPassword);
            DaoFactory.getUsersDao().updateUserPass(hashedNewPass, currentUser.getUsername());
            request.getSession().setAttribute("passupdate", true);
            response.sendRedirect("/update-profile?success=true");

        }

    }
}
