package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ViewAdServlet", value = "/view-ad")
public class ViewAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().getAd(id);
        if (ad == null) {
            response.sendRedirect("/ads");
        } else {
            request.setAttribute("id", ad.getId());
            request.setAttribute("userId", ad.getUserId());
            request.setAttribute("title", ad.getTitle());
            request.setAttribute("description", ad.getDescription());
            request.getRequestDispatcher("/WEB-INF/ads/view-ad.jsp").forward(request, response);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
