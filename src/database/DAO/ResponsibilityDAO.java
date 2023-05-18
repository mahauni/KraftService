package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Responsibility;

import java.sql.Connection;
import java.sql.SQLException;

public class ResponsibilityDAO {
    private static Connection connection;

    public ResponsibilityDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(Responsibility responsibility) {}

    public void delete() {}

    public void update() {}

    public void selectAll() {}

    public void selectById() {}
}
