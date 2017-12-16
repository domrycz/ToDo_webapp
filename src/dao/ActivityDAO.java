package dao;

import controller.ConnectionProvider;
import model.Activity;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ActivityDAO {

    private final static String CREATE = "INSERT INTO activity (name, date) VALUES (?, ?)";
    private final static String READ = "SELECT id, name, date FROM activity GROUP BY date DESC;";
    private final static String DELETE = "DELETE FROM actiity WHERE id = ?";

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public boolean create(Activity activity) {
        boolean result = false;
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(CREATE)
        )
        {
            prepStatement.setString(1, activity.getaName());
            prepStatement.setObject(2, activity.getaDate());
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
        )
        { while(resultSet.next()) {
            Activity activity = new Activity();
            activity.setaName(resultSet.getString("name"));
            LocalDate date = LocalDate.parse(resultSet.getString("date"), dtf);
            // TODO probably I have to add "id" parameter to this activity object
            activity.setaDate(date);
            activities.add(activity);
        }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return activities;
    }

    public boolean delete(Activity activity) {
        boolean result = false;
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStatement = conn.prepareStatement(DELETE);
             ResultSet resultSet = prepStatement.executeQuery()
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
