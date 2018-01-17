package controller;

import dao.ActivityDAO;
import model.Activity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelActivity", urlPatterns = "/DelActivity")
public class DelActivity extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Activity activity = new Activity();
        activity.setId(Integer.valueOf(request.getParameter("id")));
        ActivityDAO dao = new ActivityDAO();
        dao.delete(activity);

        response.sendRedirect("SqlServlet");
    }

}
