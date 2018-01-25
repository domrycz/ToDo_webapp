package dao;

import controller.ConnectionProvider;
import model.Activity;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ActivityDAO {

    private final static String CREATE = "INSERT INTO activity (name, date, time) VALUES (?, ?, ?)";
    private final static String READ = "SELECT id, name, date, time FROM activity GROUP BY date, time";
    private final static String READ_ONE = "SELECT * FROM activity WHERE id = ?";
    private final static String UPDATE = "UPDATE activity SET name = ?, date = ?, time = ? WHERE id = ?";
    private final static String DELETE = "DELETE FROM activity WHERE id = ?";

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter dtfT = DateTimeFormatter.ofPattern("HH:mm");

    public boolean create(Activity activity) {
        boolean result = false;
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(CREATE)
        )
        {
            prepStatement.setString(1, activity.getaName());
            prepStatement.setObject(2, activity.getaDate());
            prepStatement.setObject(3, activity.getaTime());
            int rowsAffected = prepStatement.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return result;
    }

    public List<Activity> read() {
        List<Activity> activities = new ArrayList<>();
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(READ);
             ResultSet resultSet = prepStatement.executeQuery()
        ) {
            while(resultSet.next()) {
            Activity activity = new Activity();
            activity.setId(resultSet.getInt("id"));
            activity.setaName(resultSet.getString("name"));
            LocalDate date = LocalDate.parse(resultSet.getString("date"), dtf);
            activity.setaDate(date);
            /* "substring" was added because MySQL saves time in hh:mm:ss format - but I don't want to use seconds
                There is a problem only when reading data - and there is no problem during save to db operation
             */
            LocalTime time = LocalTime.parse(resultSet.getString("time").substring(0, 5), dtfT);
            activity.setaTime(time);
            activities.add(activity);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return activities;
    }

    public Activity readOne(int id) {
        Activity activity = new Activity();

        Connection conn = null;
        PreparedStatement prepStatement = null;
        ResultSet resultSet = null;

        try {
            conn = ConnectionProvider.getConnection();
            prepStatement = conn.prepareStatement(READ_ONE);
            prepStatement.setInt(1, id);
            resultSet = prepStatement.executeQuery();

            while(resultSet.next()) {
                activity.setId(resultSet.getInt("id"));
                activity.setaName(resultSet.getString("name"));
                LocalDate date = LocalDate.parse(resultSet.getString("date"), dtf);
                activity.setaDate(date);
                LocalTime time = LocalTime.parse(resultSet.getString("time").substring(0, 5), dtfT);
                activity.setaTime(time);
            }
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                resultSet.close();
                prepStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return activity;
    }

    public boolean update(Activity activity) {

        boolean result = false;
        Connection conn = null;
        PreparedStatement prepStatement = null;

        try {
            conn = ConnectionProvider.getConnection();
            prepStatement = conn.prepareStatement(UPDATE);
            prepStatement.setString(1, activity.getaName());
            prepStatement.setObject(2, activity.getaDate());
            prepStatement.setObject(3, activity.getaTime());
            prepStatement.setInt(4, activity.getId());

            int rowsAffected = prepStatement.executeUpdate();
            if (rowsAffected > 0) {
                result = true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                prepStatement.close();
                conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return result;
    }

    public boolean delete(Activity activity) {
        boolean result = false;
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(DELETE)
        ) {
            prepStatement.setInt(1, activity.getId());
            int rowsAffected = prepStatement.executeUpdate();
            if (rowsAffected == 1) {
                result = true;
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return result;
    }
}
