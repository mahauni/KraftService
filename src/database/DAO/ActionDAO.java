package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ActionDAO {
    private static Connection connection;

    public ActionDAO() {
        connection = DatabaseConnection.connect();
    }

    public void insert(Action action) throws SQLException {
        String sql = "INSERT INTO USERS(NAME, EMAIL, PASSWORD, REGISTER_DATE) VALUES(?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.execute();
        stmt.close();
    }

    public void delete(int id) {}

    public void update(Action action) {}

    public List<Action> selectAll() {
        List<Action> actions = new ArrayList<>();

        return actions;
    }

    public Action selectById(int id) {
        Action action = null;

        return action;
    }
}
