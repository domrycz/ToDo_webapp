package controller;

import dao.ActivityDAO;
import model.Activity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SqlServlet", urlPatterns = "/SqlServlet")
public class SqlServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ActivityDAO dao = new ActivityDAO();
        List<Activity> activities = dao.read();
        request.setAttribute("activities", activities);
        request.getRequestDispatcher("activities.jsp").forward(request, response);
    }

}
