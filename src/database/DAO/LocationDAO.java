package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Location;

import java.sql.Connection;

public class LocationDAO {
    private static Connection connection;

    public LocationDAO() {
        connection = DatabaseConnection.connect();
    }

    public void insert(Location location) {}

    public void delete() {}

    public void update() {}

    public void selectAll() {}

    public void selectById() {}
}
