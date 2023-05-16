package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Solution;

import java.sql.Connection;

public class SolutionDAO {
    private static Connection connection;

    public SolutionDAO() {
        connection = DatabaseConnection.connect();
    }

    public void insert(Solution solution) {}

    public void delete() {}

    public void update() {}

    public void selectAll() {}

    public void selectById() {}
}
