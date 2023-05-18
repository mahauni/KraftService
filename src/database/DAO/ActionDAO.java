package database.DAO;

// changed javabean and need to fix this bullshit

import database.connection.DatabaseConnection;
import javaBeans.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionDAO {
    private static Connection connection;

    public ActionDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(Action action) {
        String sql = "INSERT INTO ACTION(NAME, DESCRIPTION) VALUES(?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, action.getName());
            stmt.setString(2, action.getDescription());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM ACTIONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Action action) {
        String sql = "UPDATE ACTIONS SET NAME=?, DESCRIPTION=? WHERE ID=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, action.getName());
            stmt.setString(2, action.getDescription());
            stmt.setInt(3, action.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Action> selectAll() {
        List<Action> actions = new ArrayList<>();
        String sql = "SELECT * FROM ACTIONS";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Action action = new Action();
                action.setId(rs.getInt("ID"));
                action.setName(rs.getString("NAME"));
                action.setDescription(rs.getString("DESCRIPTION"));

                actions.add(action);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actions;
    }

    public Action selectById(int id) {
        Action action = null;
        String sql = "SELECT * FROM ACTIONS WHERE ID=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                action = new Action();
                action.setId(rs.getInt("ID"));
                action.setName(rs.getString("NAME"));
                action.setDescription(rs.getString("DESCRIPTION"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return action;
    }
}
