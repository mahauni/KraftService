package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.URL;

import java.sql.Connection;

public class UrlDAO {
    private static Connection connection;

    public UrlDAO() {
        connection = DatabaseConnection.connect();
    }

    public void insert(URL url) {}

    public void delete() {}

    public void update() {}

    public void selectAll() {}

    public void selectById() {}
}
