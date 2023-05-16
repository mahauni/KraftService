package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Problem;

import java.sql.Connection;

public class ProblemDAO {
    private static Connection connection;

    public ProblemDAO() {
        connection = DatabaseConnection.connect();
    }

    public void insert(Problem problem) {}

    public void delete() {}

    public void update() {}

    public void selectAll() {}

    public void selectById() {}
}
