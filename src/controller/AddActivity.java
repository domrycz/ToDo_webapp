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

@WebServlet(name = "AddActivity", urlPatterns = "/AddActivity")
public class AddActivity extends HttpServlet {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter dtfT = DateTimeFormatter.ofPattern("HH:mm");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDate aDate = LocalDate.parse(request.getParameter("date"), dtf);
        String aName = request.getParameter("name");
        LocalTime aTime = LocalTime.parse(request.getParameter("time"), dtfT);
        Activity activity = new Activity(aName, aDate, aTime);
        ActivityDAO dao = new ActivityDAO();

        if(dao.create(activity)) {
            request.getRequestDispatcher("SqlServlet").forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}