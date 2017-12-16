package controller;


import dao.ActivityDAO;
import model.Activity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "AddActivity", urlPatterns = "/AddActivity")
public class AddActivity extends HttpServlet {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate aDate = LocalDate.parse(request.getParameter("date"), dtf);
        String aName = request.getParameter("name");
        Activity activity = new Activity(aName, aDate);
        ActivityDAO dao = new ActivityDAO();
        dao.create(activity);
        request.getRequestDispatcher("SqlServlet").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }



}
