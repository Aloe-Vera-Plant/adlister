package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        if (request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("intendedpage", "profile");
            response.sendRedirect("/login");
        }
        User currentUser = (User) request.getSession().getAttribute("user");

        request.setAttribute("profilepic", currentUser.pfp);
        request.setAttribute("ads", DaoFactory.getAdsDao().searchAdsByUserID(currentUser.getId()));

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
