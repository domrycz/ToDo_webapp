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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "EditActivity", urlPatterns = "/EditActivity")
public class EditActivity extends HttpServlet {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter dtfT = DateTimeFormatter.ofPattern("HH:mm");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        LocalDate date = LocalDate.parse(request.getParameter("date"), dtf);
        LocalTime time = LocalTime.parse(request.getParameter("time"), dtfT);

        Activity activity = new Activity(name, date, time);
        activity.setId(id);

        ActivityDAO dao = new ActivityDAO();

        if(dao.update(activity)) {
            response.sendRedirect("SqlServlet");
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        ActivityDAO dao = new ActivityDAO();
        Activity activity = dao.readOne(id);

        request.setAttribute("activity", activity);

        request.getRequestDispatcher("edit_activity.jsp").forward(request, response);
    }
}