package database.DAO;

import database.connection.DatabaseConnection;
import javaBeans.Department;

import java.sql.Connection;

public class DepartmentDAO {
    private static Connection connection;

    public DepartmentDAO() {
        connection = DatabaseConnection.connect();
    }

    public void insert(Department department) {}

    public void delete() {}

    public void update() {}

    public void selectAll() {}

    public void selectById() {}
}
