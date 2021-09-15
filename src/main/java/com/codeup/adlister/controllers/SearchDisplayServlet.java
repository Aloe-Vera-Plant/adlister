package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.SearchDisplayServlet", urlPatterns = "/ads/search/display")
public class SearchDisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        String adToSearchFor = request.getParameter("adToSearchFor");
        request.setAttribute("ads", DaoFactory.getAdsDao().search(adToSearchFor)); // <<< I think this returns a list of ads, might need to store in a variable to loop
        request.getRequestDispatcher("/WEB-INF/ads/search-form.jsp")
            .forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        String adToSearchFor = request.getParameter("adToSearchFor");
        request.setAttribute("ads", DaoFactory.getAdsDao().search(adToSearchFor)); // <<< I think this returns a list of ads, might need to store in a variable to loop
        request.getRequestDispatcher("/WEB-INF/ads/search-form.jsp")
            .forward(request, response);
    }


}
