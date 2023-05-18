package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Department;

import java.sql.Connection;
import java.sql.SQLException;

public class DepartmentDAO {
    private static Connection connection;

    public DepartmentDAO() throws SQLException {
        connection = DatabaseConnection.connect();
    }

    public void insert(Department department) {}

    public void delete() {}

    public void update() {}

    public void selectAll() {}

    public void selectById() {}
}
