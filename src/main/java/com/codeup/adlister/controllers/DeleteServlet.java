package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/ads/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User userlog = (User) request.getSession().getAttribute("user");

        long id = Long.parseLong(request.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().getAd(id);
        if (request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("intendedpage", "profile");
            response.sendRedirect("/login");
            return;
        } else if (!request.getParameter("uid").equals(userlog.getUsername()) && !userlog.getUsername().equals("admin")) {
            response.sendRedirect("/ads");
        } if (ad == null) {
            response.sendRedirect("/ads");
        } else {
            request.setAttribute("id", ad.getId());
            request.setAttribute("userId", ad.getUserId());
            request.setAttribute("title", ad.getTitle());
            request.setAttribute("description", ad.getDescription());
            request.setAttribute("img", ad.getImage());
            User user = DaoFactory.getUsersDao().findUserById(ad.getUserId());
            request.setAttribute("username", user.getUsername());
            request.setAttribute("email", user.getEmail());
            request.getRequestDispatcher("/WEB-INF/ads/delete.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        User currentUser = (User) request.getSession().getAttribute("user");

        Ad ad = new Ad(
                currentUser.getId(),
                request.getParameter("title"),
                request.getParameter("description"),
                request.getParameter("img")

        );

        Long adid = Long.parseLong(request.getParameter("adid"));

        if (Integer.parseInt(request.getParameter("confirm")) > 0) {
            try {
                DaoFactory.getAdsDao().deleteAdById(adid);
                response.sendRedirect("/ads");
            } catch (Exception e) {
                response.sendRedirect("/ads");
            }
        } else {
            response.sendRedirect("/ads");
        }


    }
}
