package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("user") == null) {
            request.getSession().setAttribute("intendedpage", "ads/create");
            response.sendRedirect("/login");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currentUser = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title");
        String img = request.getParameter("img");
        String description = request.getParameter("description");
        if (Form.hasEmptyInputs(new String[]{title, description})) {
            response.sendRedirect("/ads/create");
            return;
        }

        Ad ad = new Ad(currentUser.getId(), title, description, img);


        ad.setId(DaoFactory.getAdsDao().insert(ad));

        String valueOf = "";
        if (request.getParameter("categories1") != null) {
            valueOf = request.getParameter("categories1");
            DaoFactory.getAdsDao().insertIntoAdsCats(valueOf, ad.getId());
        }
        if (request.getParameter("categories2") != null) {
            valueOf = request.getParameter("categories2");
            DaoFactory.getAdsDao().insertIntoAdsCats(valueOf, ad.getId());
        }
        if (request.getParameter("categories3") != null) {
            valueOf = request.getParameter("categories3");
            DaoFactory.getAdsDao().insertIntoAdsCats(valueOf, ad.getId());
        }
        if (request.getParameter("categories4") != null) {
            valueOf = request.getParameter("categories4");
            DaoFactory.getAdsDao().insertIntoAdsCats(valueOf, ad.getId());
        }


        response.sendRedirect("/ads");
    }
}
